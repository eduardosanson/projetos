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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="CURSO") 
public class Curso {

	@Id
	@Column(name="CURSO_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer curso_Id;
	
	@Column(name="NOME")
	private String nome;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="IDENTIFICADOR_CURSO_MATERIA",
				joinColumns={@JoinColumn(name="CURSO_ID")},
				inverseJoinColumns={@JoinColumn(name="MATERIA_ID")})
	private List<Materia> materia_Id;
	
	@ManyToOne
	@JoinColumn(name="CAMPUS_ID")
	private Campus campus;
	
	@Override
	public String toString() {
		return "Curso [curso_Id=" + curso_Id + ", nome=" + nome + "]";
	}
	public Curso(Integer curso_Id, String nome) {
		super();
		this.curso_Id = curso_Id;
		this.nome = nome;
	}
	public Curso() {
		
	}

	public List<Materia> getMateria_Id() {
		return materia_Id;
	}
	public void setMateria_Id(List<Materia> materia_Id) {
		this.materia_Id = materia_Id;
	}
	public Integer getCurso_Id() {
		return curso_Id;
	}
	public void setCurso_Id(Integer curso_Id) {
		this.curso_Id = curso_Id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
