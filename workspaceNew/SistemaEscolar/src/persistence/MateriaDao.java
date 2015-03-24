package persistence;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import entity.Materia;

public class MateriaDao extends Dao {

	@Override
	public void cadastrar(Object o) {
		Materia m = new Materia();
		m = (Materia)o;
		ses = HibernateUtil.getSessionFactory().openSession();
		tran = ses.beginTransaction();
		ses.save(m);
		tran.commit();
		ses.close();
	}
	
	public Integer getId(String nomeCurso){
		ses = HibernateUtil.getSessionFactory().openSession();
		cri = ses.createCriteria(Materia.class);
		cri.add(Restrictions.eq("nome", nomeCurso));
		Materia ma = (Materia)cri.uniqueResult();
		return ma.getMateria_Id();
		
	}
	public List<Materia> listaDeMateria(){
		ses = HibernateUtil.getSessionFactory().openSession();
		cri = ses.createCriteria(Materia.class);
		List<Materia> listaDeMateira = cri.list();
		
		return listaDeMateira;
	}

	@Override
	public void excluir(Object o) {
		// TODO Auto-generated method stub
		
	}

}
