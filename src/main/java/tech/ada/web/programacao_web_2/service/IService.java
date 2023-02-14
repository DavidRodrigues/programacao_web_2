package tech.ada.web.programacao_web_2.service;

import java.util.List;

public interface IService<T> {
	
	List<T> getAll();
	
	T find(Long id);
	
	T save(T entity);

	T edit(Long id, T entity);
	
	void delete(Long id);
	
}
