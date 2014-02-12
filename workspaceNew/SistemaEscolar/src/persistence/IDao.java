package persistence;

import java.util.List;

public interface IDao<E> {
	
	void create(E obj)throws Exception;
	void update(E obj)throws Exception;
	void delete(E obj)throws Exception;
	
	List<E> listar()throws Exception;
	

}
