package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

@Entity
@SequenceGenerator(name="seqprod", sequenceName="seqprod")
public class Produto {

	@Id
	@GeneratedValue(generator="seqprod")
	@Column
	private Integer idProduto;
	@Column(length=30)
	private String nome;
	@Column
	private Integer estoque;
	@Column
	private Double valor;
	@Column
	@Temporal(TemporalType.DATE)
	private Date validade;
	@ManyToOne 
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	
	
	
	@Formula("estoque * valor")
	private Double totalEstoque;

	public Produto(Integer idProduto, String nome, Integer estoque,
			Double valor, Date validade) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.estoque = estoque;
		this.valor = valor;
		this.validade = validade;
	}
	
	public Produto() {
		
	}

	
	public Double getTotalEstoque() {
		return totalEstoque;
	}

	public void setTotalEstoque(Double totalEstoque) {
		this.totalEstoque = totalEstoque;
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
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome
				+ ", estoque=" + estoque + ", valor=" + valor + ", validade="
				+ validade + "]";
	}
	
	
	
}
