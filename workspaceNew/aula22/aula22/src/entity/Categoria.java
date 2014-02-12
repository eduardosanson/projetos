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

@Entity
@SequenceGenerator(name="seqcat", sequenceName="seqcat")
@NamedQueries({
	@NamedQuery(name="listaCategoria", query="SELECT c FROM Categoria c")
})
public class Categoria {

	@Id
	@GeneratedValue(generator="seqcat")
	@Column
	private Integer idCategoria;
	@Column
	private String nomeCategoria;
	@OneToMany(mappedBy="categoria")
	private List<Produto> produtos;
	
	public Categoria(Integer idCategoria, String nomeCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
	}
	public Categoria() {
		super();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nomeCategoria="
				+ nomeCategoria + "]";
	}
	
	
	
}
