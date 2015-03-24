package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="MATERIA")
public class Materia {
	
	@Id
	@Column(name="MATERIA_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer materia_Id;
	
	@Column(name="NOME")
	private String  nome;
	
	@Column(name="PESO")
	private Integer peso;
	
	@Override
	public String toString() {
		return "Materia [materia_Id=" + materia_Id + ", nome=" + nome
				+ ", peso=" + peso + "]";
	}
	public Integer getMateria_Id() {
		return materia_Id;
	}
	public Materia() {

		
	}
	public Materia(Integer materia_Id, String nome, Integer peso) {
		super();
		this.materia_Id = materia_Id;
		this.nome = nome;
		this.peso = peso;
	}
	public void setMateria_Id(Integer materia_Id) {
		this.materia_Id = materia_Id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	

}
