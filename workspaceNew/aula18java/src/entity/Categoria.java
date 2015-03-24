package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="seqcategoria", sequenceName="seqcategoria")
@NamedQueries({
	@NamedQuery(name="categoriaALL", query="SELECT c FROM Categoria c")
})
public class Categoria {

	@Id
	@GeneratedValue(generator="seqcategoria")
	@Column
	private Integer idCategoria;
	@Column
	private String nome;
	
	@OneToMany(mappedBy="categoria")
	private List<Produto> produto;
	
	public Categoria(Integer idCategoria, String nome) {
		super();
		this.idCategoria = idCategoria;
		this.nome = nome;
	}
	public Categoria() {
		super();
	}
	
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nome=" + nome + "]";
	}
	
	
	
}
