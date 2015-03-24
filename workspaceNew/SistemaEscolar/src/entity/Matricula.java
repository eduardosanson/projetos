package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="MATRICULA")
public class Matricula {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MATRICULA_ID")
	private Integer matricula_id;
	
	@ManyToOne
	@JoinColumn(name="ALUNO_ID")
	private Aluno aluno_id;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="NUMERO_MATRICULA")
	private String matricula;
	

	public Matricula(Integer matricula_id, Aluno aluno_id) {
		super();
		this.matricula_id = matricula_id;
		this.aluno_id = aluno_id;
	}

	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMatricula_id() {
		return matricula_id;
	}

	public void setMatricula_id(Integer matricula_id) {
		this.matricula_id = matricula_id;
	}

	public Aluno getAluno_id() {
		return aluno_id;
	}

	public void setAluno_id(Aluno aluno_id) {
		this.aluno_id = aluno_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
