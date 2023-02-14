package tech.ada.web.programacao_web_2.model.mapper;

import java.util.List;


public interface IMapper<T, R> {

	List<R> parseListDTO(List<T> entities);
	List<T> parseListEntity(List<R> entities);
	
	R parseDTO(T entity);
	T parseEntity(R entity);
}
