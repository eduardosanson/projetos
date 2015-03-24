package config;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import persistence.AlunoDao;
import persistence.CampusDao;
import persistence.CursoDao;
import persistence.MateriaDao;
import entity.Aluno;
import entity.Campus;
import entity.Curso;
import entity.Endereco;
import entity.Materia;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("config/mysql_hibernate.cfg.xml");
		
		new SchemaExport(cfg).create(true, true);
		
		
		
		try {
			
		////////////////////////////CRIANDO CAMPUS FICTICIOS////////////////////////////////
		Campus campus1 = new Campus(null, "Centro I");
		campus1.setEndereco(new Endereco(null, "Rua dezenove", 20, null));
		
		Campus campus2 = new Campus(null, "Centro II");
		campus2.setEndereco(new Endereco(null, "Rua oitenta e um", 150, null));
		
		Campus campus3 = new Campus(null, "Centro III");
		campus3.setEndereco(new Endereco(null, "Rua Sem Nome", 984, null));
		
		CampusDao cpd = new CampusDao();
		cpd.create(campus1);
		cpd.create(campus2);
		cpd.create(campus3);
		
		
		/////////////////////////////CADASTRO DE CLIENTE////////////////////////////////////
		List<Campus> listacaCampus = new ArrayList<Campus>();
		listacaCampus.add(campus1);
		Aluno al = new Aluno(null, "Eduardo", "06076413476",null , null);
		Aluno al1 = new Aluno(null, "Adriano", "98591553489", null, null);
		Aluno al2 = new Aluno(null, "Carlos", "68206172831", null, null);
		Aluno al3 = new Aluno(null, "Pedro", "45282338866", null, null);
		Aluno al4 = new Aluno(null, "Rafael", "26325545273", null, null);
		
		AlunoDao ad = new AlunoDao();
		
		ad.create(al);
		ad.create(al1);
		ad.create(al2);
		ad.create(al3);
		ad.create(al4);
		
		
		//////////////////////////////////////CADASTRO DE MATERIA//////////////////////////////
		Materia ma = new Materia(null, "Segurança da informação", 6);
		Materia ma1 = new Materia(null, "POO", 4);
		Materia ma2 = new Materia(null, "Padrão de projetos", 6);
		Materia ma3 = new Materia(null, "Gestão", 4);
		Materia ma4 = new Materia(null, "Arquitetura de Sistemas", 4);
		Materia ma5 = new Materia(null, "Ciencia da Computação", 4);
		Materia ma6 = new Materia(null, "Redes", 4);
		Materia ma7 = new Materia(null, "SO", 4);
		Materia ma8 = new Materia(null, "Analise de Sistemas", 2);
		Materia ma9 = new Materia(null, "Paradigmas", 6);
		Materia ma10 = new Materia(null, "Engearia de softwares", 2);
		Materia ma11 = new Materia(null, "ooo", 2);
		Materia ma12 = new Materia(null, "sasdaa", 2);
		
		MateriaDao md = new MateriaDao();
		
		md.create(ma);
		md.create(ma1);
		md.create(ma2);
		md.create(ma3);
		md.create(ma4);
		md.create(ma5);
		md.create(ma6);
		md.create(ma7);
		md.create(ma8);
		md.create(ma9);
		md.create(ma10);
		md.create(ma11);
		md.create(ma12);
		
		List<Materia> listaMateria = md.listar();
		
		///////////////////////////////CRIANDO CURSOS FICTICIOS///////////////////////////////
		Curso c1 = new Curso(null, "Sistema de Informação");
		c1.setMateria_Id(listaMateria);
		Curso c2 = new Curso(null, "Análise de Sistema");
		c2.setMateria_Id(listaMateria);
		Curso c3 = new Curso(null, "Engearia de Software");
		c3.setMateria_Id(listaMateria);
		Curso c4 = new Curso(null, "Segurança");
		c4.setMateria_Id(listaMateria);
		Curso c5 = new Curso(null, "Desenvolvimento de Software");
		c5.setMateria_Id(listaMateria);
		
		CursoDao crsd = new CursoDao();
		
		crsd.create(c1);
		crsd.create(c2);
		crsd.create(c3);
		crsd.create(c4);
		crsd.create(c5);
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
	}

}
