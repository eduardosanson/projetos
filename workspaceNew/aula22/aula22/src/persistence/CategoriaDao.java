package persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Categoria;

public class CategoriaDao {

	Session session;
	Transaction transaction;
	Query query;
	Criteria criteria;
	
	public void cadastrar(Categoria c)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		session.close();
	}
	
	public List<Categoria> listar()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.getNamedQuery("listaCategoria");
		List<Categoria> lista = query.list();
		session.close();
		return lista;
	}
	
}
