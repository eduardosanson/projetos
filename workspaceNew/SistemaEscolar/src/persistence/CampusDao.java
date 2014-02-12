package persistence;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import entity.Campus;

public class CampusDao extends Dao{

	@Override
	public void cadastrar(Object o) {
		Campus cp = (Campus)o;
		ses = HibernateUtil.getSessionFactory().openSession();
		tran = ses.beginTransaction();
		ses.save(cp);
		tran.commit();
		ses.close();
	}
	

	@Override
	public void excluir(Object o) {
		// TODO Auto-generated method stub
		
	}

}
