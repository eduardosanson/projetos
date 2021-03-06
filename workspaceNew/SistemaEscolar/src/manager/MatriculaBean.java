package manager;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import persistence.CursoDao;
import entity.Curso;

@ManagedBean(name="mBean")
@RequestScoped
public class MatriculaBean {
	
	private Curso curso;
	
	private List<SelectItem> listaCurso;
	
	public MatriculaBean() {
		curso = new Curso();
		
	}
	
	public List<SelectItem> getListaCurso() {
		listaCurso = new ArrayList<SelectItem>();
		try {
			for(Curso c : new CursoDao().listaDeCursos()){
				SelectItem si = new SelectItem(c.getCurso_Id(), c.getNome());
				listaCurso.add(si);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaCurso;
	}



	public void setListaCurso(List<SelectItem> listaCurso) {
		this.listaCurso = listaCurso;
	}



	public MatriculaBean(Curso curso) {
		super();
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	

}
