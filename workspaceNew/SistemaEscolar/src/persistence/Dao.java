package persistence;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



public abstract class Dao {
	
	protected Transaction 	tran;
	protected Session   	ses;
	protected Criteria   	cri;
	protected Query     	que;
	
	public abstract void cadastrar(Object o);
	
	public abstract void excluir(Object o);
	
}
