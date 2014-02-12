package persistence;

import java.util.ArrayList;
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
	
	public List<Produto> buscarNomeAndCategoria(String nome, Integer idCategoria)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		List<Produto> lista = new ArrayList<Produto>();
		criteria = session.createCriteria(Produto.class);
		/*criteria.add(Restrictions.and(
				Restrictions.ilike("nome", nome), 
				Restrictions.eq("categoria.idCategoria", idCategoria)
		));*/
		criteria.add(Restrictions.ilike("nome", nome));
		if(idCategoria != -1)
			criteria.add(Restrictions.eq("categoria.idCategoria", idCategoria));
		criteria.addOrder(Order.asc("nome"));
		criteria.setMaxResults(500);
		lista = criteria.list();
		session.close();
		return lista;
	}
	
}
