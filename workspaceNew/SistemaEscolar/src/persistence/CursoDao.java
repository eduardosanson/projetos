package persistence;

import java.util.List;


import entity.Curso;
import entity.Matricula;

public class CursoDao extends Dao {

	@Override
	public void cadastrar(Object o) {
		Curso curso = (Curso)o;
		ses = HibernateUtil.getSessionFactory().openSession();
		tran = ses.beginTransaction();
		ses.saveOrUpdate(curso);
		tran.commit();
		ses.close();
		
	}
	public List<Curso> listaDeCursos(){
		ses = HibernateUtil.getSessionFactory().openSession();
		cri = ses.createCriteria(Curso.class);
		List<Curso>listaCampus = cri.list();
		return listaCampus;
	}
	public void update(Matricula ma){
		
	}

	@Override
	public void excluir(Object o) {
		// TODO Auto-generated method stub
		
	}

}
