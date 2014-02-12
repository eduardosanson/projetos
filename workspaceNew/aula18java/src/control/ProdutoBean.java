package control;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

import persistence.CategoriaDao;
import persistence.HibernateUtil;
import persistence.ProdutoDao;

import entity.Categoria;
import entity.Produto;

@ManagedBean(name="pBean")
@RequestScoped
public class ProdutoBean {

	private Produto produto;
	private List<SelectItem> lista;
	private Categoria categoria;
	private List<Produto> listaP;
	
	public ProdutoBean() {
		produto = new Produto();
		categoria = new Categoria();
		listaP = new ArrayList<Produto>();
	}
	
		
	public List<Produto> getListaP() {
		return listaP;
	}

	public void setListaP(List<Produto> listaP) {
		this.listaP = listaP;
	}

	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<SelectItem> getLista() {
		try{
			lista = new ArrayList<SelectItem>();
			for(Categoria c : new CategoriaDao().listar()){
				lista.add(new SelectItem(c.getIdCategoria(), c.getNome()));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void setLista(List<SelectItem> lista) {
		this.lista = lista;
	}
	
	public void buscar()
	{
		try{
			
			if(produto.getNome().equalsIgnoreCase("")){
				listaP = new ArrayList<Produto>();
			}else{
				listaP = new ProdutoDao().buscar(produto.getNome()+ "%");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try{
			ProdutoDao pd = new ProdutoDao();
			produto.setCategoria(categoria);
			pd.cadastrar(produto);
			produto = new Produto();
			
			fc.addMessage("form1", new FacesMessage(FacesMessage.SEVERITY_INFO, "GRAVADO", 
					"Produto cadastrado com sucesso!"));
		}catch (Exception e) {
			e.printStackTrace();
			fc.addMessage("form1", new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERRO", 
					"Produto nao pode ser gravado!"));
		}
		
		return null;
	}
	
	public String relatorio(){
		
		try{
			
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("PNOME", produto.getNome() + "%");
			
			InputStream arquivo = FacesContext.getCurrentInstance().getExternalContext()
						.getResourceAsStream("aula19.jasper");
			
			byte[] pdf = JasperRunManager.runReportToPdf(arquivo, param, 
					HibernateUtil.getSessionFactory().openSession().connection());
			
			HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext()
					.getResponse();
			
			ServletOutputStream out = res.getOutputStream();
			out.write(pdf);
			out.flush();
			
			FacesContext.getCurrentInstance().responseComplete();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
