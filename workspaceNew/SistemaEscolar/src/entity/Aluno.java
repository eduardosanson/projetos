package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="ALUNO")
public class Aluno {

	@Id
	@Column(name = "ALUNO_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aluno_Id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CPF",unique=true)
	private String cpf;

	@Column(name = "NASC")
	@Temporal(TemporalType.DATE)
	private Date nasc;
	
	@OneToMany(mappedBy="matricula_id")
	@JoinColumn(name = "ALUNO_ID")
	private List<Matricula> matricula;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="IDENTIFICADOR_ALUNO_CAMPUS",
			   joinColumns={@JoinColumn(name="CAMPUS-ID")},
			   inverseJoinColumns={@JoinColumn(name="ALUNO_ID")})
	private List<Campus> campus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENDERECO_ID")
	private Endereco endereco;
	
	@ManyToMany
	@JoinTable(name="IDENTIFICADOR_ALUNO_MATERIA",
			   joinColumns={@JoinColumn(name="ALUNO_ID")},
			   inverseJoinColumns={@JoinColumn(name="MATERIA_ID")})
	private List<Materia> materia;
	
	@Column(name="REGISTRADO")
	@Temporal(TemporalType.DATE)
	private Date registrado;
	

	@Override
	public String toString() {
		return "Aluno [aluno_Id=" + aluno_Id + ", nome=" + nome + ", cpf="
				+ cpf + "]";
	}



	public Aluno() {

	}

	

	public Aluno(Integer aluno_Id, String nome, String cpf, Date nasc,
			List<Matricula> matricula) {
		super();
		this.aluno_Id = aluno_Id;
		this.nome = nome;
		this.cpf = cpf;
		this.nasc = nasc;
		this.matricula = matricula;
	}
	

	public Aluno(Integer aluno_Id, String nome, String cpf, Date nasc,
			List<Matricula> matricula, List<Campus> campus) {
		super();
		this.aluno_Id = aluno_Id;
		this.nome = nome;
		this.cpf = cpf;
		this.nasc = nasc;
		this.matricula = matricula;
		this.campus = campus;
	}
	

	public List<Materia> getMateria() {
		return materia;
	}



	public void setMateria(List<Materia> materia) {
		this.materia = materia;
	}



	public Date getRegistrado() {
		return registrado;
	}



	public void setRegistrado(Date registrado) {
		this.registrado = registrado;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getAluno_Id() {
		return aluno_Id;
	}

	public void setAluno_Id(int aluno_Id) {
		this.aluno_Id = aluno_Id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}


	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}

	public void setAluno_Id(Integer aluno_Id) {
		this.aluno_Id = aluno_Id;
	}

	public List<Campus> getCampus() {
		return campus;
	}

	public void setCampus(List<Campus> campus) {
		this.campus = campus;
	}
	

}
