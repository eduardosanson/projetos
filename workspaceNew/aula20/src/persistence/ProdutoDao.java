package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import entity.Produto;

public class ProdutoDao {

	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;
	
	public void cadastrar(Produto p)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();
	}
	
	public List<Produto> listar()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Produto.class);
		//criteria.add(Restrictions.eq("categoria.idcategoria", 10));
		criteria.addOrder(Order.asc("nome"));
		List<Produto> lista = criteria.list();
		session.close();
		return lista;
	}
	
}
