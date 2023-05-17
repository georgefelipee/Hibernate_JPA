package br.com.gefelipe.domain;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tb_curso")
public class Curso {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "curso_seq")
	@SequenceGenerator(name = "curso_seq",sequenceName = "sq_curso", initialValue = 1,allocationSize = 1)
	private Long id;
	
	@Column(name = "CODIGO", length = 30, nullable = false, unique = true)
	private String codigo;

	@Column(name = "NOME", length = 30, nullable = false, unique = true)
	private String nome;

	@Column(name = "DESCRICAO", length = 30, nullable = false, unique = true)
	private String descricao;
	
	@OneToMany(mappedBy = "curso")
	private List<Matricula> matriculas;

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
