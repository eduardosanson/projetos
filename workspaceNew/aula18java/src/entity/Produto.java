package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
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
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
