package manager;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import persistence.AlunoDao;
import entity.Aluno;

@ManagedBean(name="aBean")
@RequestScoped
public class AlunoBean {
	
	private Aluno aluno;
	private List<Aluno> listaDeAluno;

	
	public AlunoBean() {
		aluno = new Aluno();
		listaDeAluno = new ArrayList<Aluno>();
	}

	public AlunoBean(Aluno aluno) {
		super();
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
		
	public List<Aluno> getListaDeAluno() {
		return listaDeAluno;
	}

	public void setListaDeAluno(List<Aluno> listaDeAluno) {
		this.listaDeAluno = listaDeAluno;
	}

	public String cadastrar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			AlunoDao ad = new AlunoDao();
			ad.cadastrar(aluno);
			fc.addMessage("formcadastro",new FacesMessage("Aluno cadastrado com sucesso!"));
			aluno = new Aluno();
		} catch (Exception e) {
			e.printStackTrace();
			fc.addMessage("formcadastro",new FacesMessage("Erro ao cadastrar"));
		}
		return null;
	}
	
	public String buscarPorCpf(){
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			AlunoDao ad = new AlunoDao();
			listaDeAluno = ad.buscarPorCpf(aluno.getCpf());
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String buscarUmPorCpf(String cpf){
		try {
			AlunoDao ad = new AlunoDao();
			aluno = ad.buscarUmPorCpf(cpf);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
