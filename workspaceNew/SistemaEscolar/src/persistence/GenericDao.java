package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class GenericDao<E, ID extends Serializable> implements IDao<E> {

	Session session;
	Transaction transaction;
	Criteria criteria;
	Query query;
	
	E entity;
	
	
	public GenericDao(E obj) {
		this.entity = obj;
	}

	@Override
	public void create(E obj) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
		session.close();
		
	}

	@Override
	public void update(E obj) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(obj);
		transaction.commit();
		session.close();
		
	}

	@Override
	public void delete(E obj) throws Exception {
		
		session = HibernateUtil.getSessionFactory().openSession();
		transaction.begin();
		session.delete(obj);
		transaction.commit();
		session.close();
		
	}

	@Override
	public List<E> listar() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		List<E> lista = new ArrayList<E>();
		criteria = session.createCriteria(entity.getClass());
		lista = criteria.list();
		return lista;
	}

}
