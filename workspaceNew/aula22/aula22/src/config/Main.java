package config;

import java.util.Date;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import persistence.CategoriaDao;
import persistence.ProdutoDao;

import entity.Categoria;
import entity.Produto;

public class Main {

	public static void main(String[] args) {
		new SchemaExport(new AnnotationConfiguration()
		.configure("config/oracle_hibernate.cfg.xml")).create(true, true);
		
		try{
			
			Categoria c1 = new Categoria(null, "Informatica");
			Categoria c2 = new Categoria(null, "Jogos");
			Categoria c3 = new Categoria(null, "DVD");
			Categoria c4 = new Categoria(null, "Eletrodomestico");
			Categoria c5 = new Categoria(null, "Roupas");
			
			CategoriaDao cd = new CategoriaDao();
			
			cd.cadastrar(c1);
			cd.cadastrar(c2);
			cd.cadastrar(c3);
			cd.cadastrar(c4);
			cd.cadastrar(c5);
			
			System.out.println("Categoria cadastrada com sucesso!");
			
			for(Categoria c : cd.listar()){
				System.out.println(c.getNomeCategoria());
			}
			
			ProdutoDao pd = new ProdutoDao();
			Produto p = new Produto(null, "Teste", 20, 45D, new Date());
			p.setCategoria(new Categoria(1, null));
			pd.cadastrar(p);
			System.out.println("Prod cadastradi");
			
			for(Produto pp : pd.buscarNomeAndCategoria("Te%", null)){
				System.out.println(pp);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
