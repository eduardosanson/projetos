package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqcli", sequenceName="seqcli")
//SELECT c FROM Cliente c WHERE c.endereco.idEndereco = :param1
public class Cliente {

	@Id
	@GeneratedValue(generator="seqcli")
	@Column
	private Integer idCliente;
	@Column
	private String nome;
	@Column(length=20)
	private String cpf;
	@Column
	private Integer idade;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="itens",
	joinColumns=@JoinColumn(name="id_cliente"), 
	inverseJoinColumns=@JoinColumn(name="id_produto"))
	private List<Produto> produtos;
	
	public Cliente(Integer idCliente, String nome, String cpf, Integer idade) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	public Cliente() {
		super();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf="
				+ cpf + ", idade=" + idade + "]";
	}
	
	
	
}
