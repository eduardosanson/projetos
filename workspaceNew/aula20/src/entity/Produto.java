package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqprod", sequenceName="seqprod")
public class Produto {

	@Id
	@GeneratedValue(generator="seqprod")
	@Column
	private Integer idProduto;
	@Column
	private String nome;
	@Column
	private Integer estoque;
	@Column
	private Double valor;
	@ManyToMany(mappedBy="produtos")
	private List<Cliente> clientes;
	
	public Produto(Integer idProduto, String nome, Integer estoque, Double valor) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.estoque = estoque;
		this.valor = valor;
	}
	public Produto() {
		super();
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome
				+ ", estoque=" + estoque + ", valor=" + valor + "]";
	}
	
	
	
}
