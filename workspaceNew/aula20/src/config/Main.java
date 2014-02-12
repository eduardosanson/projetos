package config;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import persistence.ClienteDao;
import persistence.ProdutoDao;

import entity.Cliente;
import entity.Produto;

public class Main {

	public static void main(String[] args) {
		
		Configuration cfg = new AnnotationConfiguration()
		.configure("config/oracle_hibernate.cfg.xml");
		
		new SchemaExport(cfg).create(true, true);
		
		try{
			
			Produto p1 = new Produto(null, "Camisa", 10, 50D);
			Produto p2 = new Produto(null, "Calça", 50, 100D);
			Produto p3 = new Produto(null, "PES", 10, 199D);
			Produto p4 = new Produto(null, "Tennis", 20, 159D);
			Produto p5 = new Produto(null, "Bone", 40, 50D);
			
			ProdutoDao pd = new ProdutoDao();
			pd.cadastrar(p1);
			pd.cadastrar(p2);
			pd.cadastrar(p3);
			pd.cadastrar(p4);
			pd.cadastrar(p5);
			
			System.out.println("Produto cadastrado com sucesso!");
			
			for(Produto p : pd.listar())
				System.out.println(p);
			
			Cliente c1 = new Cliente(null, "Ana", "123.123.123-55", 20);
			ClienteDao cd = new ClienteDao();
			cd.cadastrar(c1);
			System.out.println("ok");
			
			
			Cliente c2 = cd.buscarPorCpf("123.123.123-55");
			c2.setNome("Ana da Silva");
			cd.cadastrar(c2);
			
			System.out.println("ok " + c2);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
