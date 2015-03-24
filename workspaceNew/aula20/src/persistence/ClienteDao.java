package persistence;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import entity.Cliente;

public class ClienteDao {
	
	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;
	
	public void cadastrar(Cliente c)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.saveOrUpdate(c);
		transaction.commit();
		session.close();
	}
	
	public Cliente buscarPorCpf(String cpf)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Cliente.class);
		criteria.add(Restrictions.eq("cpf", cpf));
		Cliente c = (Cliente)criteria.uniqueResult();
		session.close();
		return c;
	}

}
