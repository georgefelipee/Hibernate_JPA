package br.com.gefelipe;

import static org.junit.Assert.assertNotNull;

import java.time.Instant;

import org.junit.Test;

import br.com.gefelipe.dao.AlunoDao;
import br.com.gefelipe.dao.CursoDAO;
import br.com.gefelipe.dao.IAlunoDao;
import br.com.gefelipe.dao.ICursoDAO;
import br.com.gefelipe.dao.IMatriculaDao;
import br.com.gefelipe.dao.MatriculaDAO;
import br.com.gefelipe.domain.Aluno;
import br.com.gefelipe.domain.Curso;
import br.com.gefelipe.domain.Matricula;

public class MatriculaTest {
	
	private IMatriculaDao matriculaDao;
	
	private ICursoDAO cursoDao;
	
	private IAlunoDao alunoDao;
	
	public MatriculaTest() {
		matriculaDao = new MatriculaDAO();
		cursoDao = new CursoDAO();
		alunoDao= new AlunoDao();
	}
	
	@Test
	public void cadastrar() {
		Curso curso = criarCurso("A1");
		Aluno aluno = criarAluno("A1");
		Matricula mat = new Matricula();
		mat.setCodigo("A1");
		mat.setDataMatricula(Instant.now());
		mat.setStatus("ATIVA");
		mat.setValor(2000D);
		mat.setCurso(curso);
		mat.setAluno(aluno);
		mat = matriculaDao.cadastrar(mat);
		aluno.setMatricula(mat);
		
		assertNotNull(mat);
		assertNotNull(mat.getId());
		
	}
	

	private Aluno criarAluno(String codigo) {
		Aluno aluno = new Aluno();
		aluno.setCodigo(codigo);
		aluno.setNome("George");
		
		return alunoDao.cadastrar(aluno);
	}

	public Curso criarCurso(String codigo) {
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		curso.setDescricao("Curso Teste");
		curso.setNome("Curso de Java Back-end");
		return cursoDao.cadastrar(curso);
		
	}

}
