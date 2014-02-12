package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="CAMPUS")
public class Campus {
	
	@Id
	@Column(name="CAMPUS_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer campus_Id;
	
	@Column(name="NOME")
	private String nome;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ENDERECO_ID")
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="CURSO_ID")
	private List<Curso> curso;
	
	@Override
	public String toString() {
		return "Campus [campus_Id=" + campus_Id + ", nome=" + nome + "]";
	}
	public Campus() {
		
	}
	public Campus(Integer campus_Id, String nome) {
		super();
		this.campus_Id = campus_Id;
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getCampus_Id() {
		return campus_Id;
	}
	public void setCampus_Id(Integer campus_Id) {
		this.campus_Id = campus_Id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Curso> getCurso() {
		return curso;
	}
	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}
	
	
	

}
