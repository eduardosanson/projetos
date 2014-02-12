package persistence;


import entity.Aluno;

public class AlunoDao extends GenericDao<Aluno, Integer>{

	public AlunoDao() {
		super(new Aluno());
		// TODO Auto-generated constructor stub
	}
	
	public Aluno buscarPorCpf(Aluno al)throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		criteria = session.createCriteria(Aluno.class);
		criteria.createCriteria("cpf", al.getCpf());
		al = (Aluno) criteria.uniqueResult();
		
		return al;
	}
	
	
}
