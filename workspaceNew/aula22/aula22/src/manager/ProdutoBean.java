package manager;

import java.io.InputStream;
import java.sql.Connection;
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
	private Categoria categoria;
	
	private List<SelectItem> listaCategoria;
	private List<Produto> listaProduto;
	
	public ProdutoBean() {
		produto = new Produto();
		categoria = new Categoria();
	}
	

	public List<Produto> getListaProduto() {
		return listaProduto;
	}


	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<SelectItem> getListaCategoria() {
		listaCategoria = new ArrayList<SelectItem>();
		try{
			
			for(Categoria c : new CategoriaDao().listar()){
				SelectItem si = new SelectItem(c.getIdCategoria(), c.getNomeCategoria());
				listaCategoria.add(si);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return listaCategoria;
	}

	public void setListaCategoria(List<SelectItem> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
	
	
	public String cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			produto.setCategoria(categoria);
			ProdutoDao pd = new ProdutoDao();
			pd.cadastrar(produto);
			
			fc.addMessage("formprodutos", new FacesMessage("Produto cadastrado com sucesso!"));
			produto = new Produto();
		}catch (Exception e) {
			e.printStackTrace();
			fc.addMessage("formprodutos", new FacesMessage("Nao pode cadastrar"));
		}
		
		return null;
	}
	
	public String buscar(){
		try{
			
			ProdutoDao pd = new ProdutoDao();
			if(produto.getNome().equalsIgnoreCase("")){
				listaProduto = new ArrayList<Produto>();
				FacesContext.getCurrentInstance().addMessage("formconsultar", 
						new FacesMessage("INFORME UM NOME PARA O PRODUTO"));
			}else{
				listaProduto = pd.buscarNomeAndCategoria(produto.getNome()+"%", 
						categoria.getIdCategoria());
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String relatorio(){
		try{
			
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("pnome", produto.getNome() +"%");
			
			InputStream arquivo = FacesContext.getCurrentInstance().getExternalContext()
						.getResourceAsStream("/relatorioaula22.jasper");
			byte[] pdf = JasperRunManager.runReportToPdf(arquivo, param, 
					HibernateUtil.getSessionFactory().openSession().connection());

			
			HttpServletResponse response = (HttpServletResponse) FacesContext
					.getCurrentInstance().getExternalContext().getResponse();
			
			ServletOutputStream out = response.getOutputStream();
			out.write(pdf);
			out.flush();
			
			FacesContext.getCurrentInstance().responseComplete();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
