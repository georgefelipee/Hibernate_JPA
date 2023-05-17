package br.com.gefelipe;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.gefelipe.dao.CursoDAO;
import br.com.gefelipe.dao.ICursoDAO;
import br.com.gefelipe.domain.Curso;

public class CursoTest {
	
	private ICursoDAO cursoDao;
	
	public CursoTest() {
		
		cursoDao = new CursoDAO();
	}
	
	@Test
	public void cadastrar() {
		Curso curso = new Curso();
		curso.setCodigo("A1");
		curso.setDescricao("Curso Teste");
		curso.setNome("Curso de Java Back-end");
		curso = cursoDao.cadastrar(curso);
		
		assertNotNull(curso);
		assertNotNull(curso.getId());
	
	}

}
