package manager;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import entity.Produto;

public class ProdutoDataModel extends ListDataModel implements SelectableDataModel<Produto>{

	
	public ProdutoDataModel() {
		
	}
	
	public ProdutoDataModel(List<Produto> lista){
		super(lista);
	}
	
	@Override
	public Produto getRowData(String rowKey) {
		List<Produto> lista = (List<Produto>) getWrappedData();
		for(Produto p : lista){
			if(p.getIdProduto().equals( Integer.parseInt(rowKey)))
				return p;
		}
		return null;
	}
	
	@Override
	public Object getRowKey(Produto p) {
		return p.getIdProduto();
	}
	
}
