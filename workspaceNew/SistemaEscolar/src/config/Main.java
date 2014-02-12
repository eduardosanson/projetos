package config;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.primefaces.component.calendar.Calendar;

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
		
		
		////////////////////////////CRIANDO CAMPUS FICTICIOS////////////////////////////////
		Campus campus1 = new Campus(null, "Centro I");
		campus1.setEndereco(new Endereco(null, "Rua dezenove", 20, null));
		
		Campus campus2 = new Campus(null, "Centro II");
		campus2.setEndereco(new Endereco(null, "Rua oitenta e um", 150, null));
		
		Campus campus3 = new Campus(null, "Centro III");
		campus3.setEndereco(new Endereco(null, "Rua Sem Nome", 984, null));
		
		CampusDao cpd = new CampusDao();
		cpd.cadastrar(campus1);
		cpd.cadastrar(campus2);
		cpd.cadastrar(campus3);
		
		
		/////////////////////////////CADASTRO DE CLIENTE////////////////////////////////////
		List<Campus> listacaCampus = new ArrayList<Campus>();
		listacaCampus.add(campus1);
		Aluno al = new Aluno(null, "Eduardo", "06076413476",null , null);
		Aluno al1 = new Aluno(null, "Adriano", "98591553489", null, null);
		Aluno al2 = new Aluno(null, "Carlos", "68206172831", null, null);
		Aluno al3 = new Aluno(null, "Pedro", "45282338866", null, null);
		Aluno al4 = new Aluno(null, "Rafael", "26325545273", null, null);
		
		AlunoDao ad = new AlunoDao();
		
		ad.cadastrar(al);
		ad.cadastrar(al1);
		ad.cadastrar(al2);
		ad.cadastrar(al3);
		ad.cadastrar(al4);
		
		
		//////////////////////////////////////CADASTRO DE MATERIA//////////////////////////////
		Materia ma = new Materia(null, "Seguran�a da informa��o", 6);
		Materia ma1 = new Materia(null, "POO", 4);
		Materia ma2 = new Materia(null, "Padr�o de projetos", 6);
		Materia ma3 = new Materia(null, "Gest�o", 4);
		Materia ma4 = new Materia(null, "Arquitetura de Sistemas", 4);
		Materia ma5 = new Materia(null, "Ciencia da Computa��o", 4);
		Materia ma6 = new Materia(null, "Redes", 4);
		Materia ma7 = new Materia(null, "SO", 4);
		Materia ma8 = new Materia(null, "Analise de Sistemas", 2);
		Materia ma9 = new Materia(null, "Paradigmas", 6);
		Materia ma10 = new Materia(null, "Engearia de softwares", 2);
		Materia ma11 = new Materia(null, "ooo", 2);
		Materia ma12 = new Materia(null, "sasdaa", 2);
		
		MateriaDao md = new MateriaDao();
		
		md.cadastrar(ma);
		md.cadastrar(ma1);
		md.cadastrar(ma2);
		md.cadastrar(ma3);
		md.cadastrar(ma4);
		md.cadastrar(ma5);
		md.cadastrar(ma6);
		md.cadastrar(ma7);
		md.cadastrar(ma8);
		md.cadastrar(ma9);
		md.cadastrar(ma10);
		md.cadastrar(ma11);
		md.cadastrar(ma12);
		
		List<Materia> listaMateria = md.listaDeMateria();
		
		///////////////////////////////CRIANDO CURSOS FICTICIOS///////////////////////////////
		Curso c1 = new Curso(null, "Sistema de Informa��o");
		c1.setMateria_Id(listaMateria);
		Curso c2 = new Curso(null, "An�lise de Sistema");
		c2.setMateria_Id(listaMateria);
		Curso c3 = new Curso(null, "Engearia de Software");
		c3.setMateria_Id(listaMateria);
		Curso c4 = new Curso(null, "Seguran�a");
		c4.setMateria_Id(listaMateria);
		Curso c5 = new Curso(null, "Desenvolvimento de Software");
		c5.setMateria_Id(listaMateria);
		
		CursoDao crsd = new CursoDao();
		
		crsd.cadastrar(c1);
		crsd.cadastrar(c2);
		crsd.cadastrar(c3);
		crsd.cadastrar(c4);
		crsd.cadastrar(c5);
		
		
		
		
		
	}

}
