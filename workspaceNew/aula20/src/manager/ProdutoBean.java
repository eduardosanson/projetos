package manager;

import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import persistence.ClienteDao;
import persistence.ProdutoDao;

import entity.Cliente;
import entity.Produto;

@ManagedBean(name="pBean")
@RequestScoped
public class ProdutoBean {

	private Cliente cliente;
	private ProdutoDataModel lista;
	private Produto[] selecionados;	
	
	public ProdutoBean() {
		cliente = new Cliente();
	}

	
	public Produto[] getSelecionados() {
		return selecionados;
	}


	public void setSelecionados(Produto[] selecionados) {
		this.selecionados = selecionados;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ProdutoDataModel getLista() {
		try{
			lista = new ProdutoDataModel(new ProdutoDao().listar());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public String cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try{
			
			List<Produto> produtos = Arrays.asList(selecionados);
			cliente.setProdutos(produtos);
			
			ClienteDao cd = new ClienteDao();
			
			Cliente cli = cd.buscarPorCpf(cliente.getCpf());
			if(cli == null){
				cd.cadastrar(cliente);
				fc.addMessage("form1", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, 
							"PRODUTO", "Venda realizada com sucesso!"));
			}else{
				cli.setProdutos(produtos);
				if(cliente.getNome() != "")
					cli.setNome(cliente.getNome());
				if(cliente.getIdade() != 0)
					cli.setIdade(cliente.getIdade());
				
				cd.cadastrar(cli);
				fc.addMessage("form1", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, 
							"PRODUTO", "Nova Venda atualizada com sucesso!"));
			}
			
			cliente = new Cliente();
		}catch (Exception e) {
			e.printStackTrace();
			fc.addMessage("form1", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, 
							"PRODUTO", "Nao pode realizar a venda"));
		}
		
		return null;
	}
	
}
