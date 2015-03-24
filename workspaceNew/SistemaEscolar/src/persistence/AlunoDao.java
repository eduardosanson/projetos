package persistence;

import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.primefaces.component.calendar.Calendar;

import validator.ConverterCpf;
import entity.Aluno;

public class AlunoDao extends Dao {
	
	
	public void cadastrar(Object o){
			Aluno a = new Aluno();
			a = (Aluno)o;
			a.setCpf(new ConverterCpf().cpfLimpo(a.getCpf()));
			a.setRegistrado(new GregorianCalendar().getTime());
			ses = HibernateUtil.getSessionFactory().openSession();
			tran = ses.beginTransaction();
			ses.save(a);
			tran.commit();
			ses.close();
	}

	@Override
	public void excluir(Object o) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Aluno> buscarPorCpf(String cpf){ 
		ses = HibernateUtil.getSessionFactory().openSession();
		cri = ses.createCriteria(Aluno.class);
		cri.add(Restrictions.ilike("cpf", cpf));
		cri.addOrder(Order.asc("nome"));
		cri.setMaxResults(100);
		List<Aluno> listaDeAlunos = cri.list();
		ses.close();
		return listaDeAlunos;
		
	}
	public Aluno buscarUmPorCpf(String cpf){
		ses = HibernateUtil.getSessionFactory().openSession();
		cri = ses.createCriteria(Aluno.class);
		cri.add(Restrictions.eq("nome", cpf));
		Aluno al = (Aluno)cri.uniqueResult();
		ses.close();
		
		return al;
	}
	
	public static void main(String[] args) {
		AlunoDao ad = new AlunoDao();
		
		List<Aluno>la = ad.buscarPorCpf("124");
		System.out.println(la);
	}

}
