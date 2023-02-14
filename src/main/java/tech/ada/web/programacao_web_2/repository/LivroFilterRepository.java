package tech.ada.web.programacao_web_2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import tech.ada.web.programacao_web_2.model.entity.Livro;

@Repository
public interface LivroFilterRepository {

	List<Livro> filter(Livro livro);
	
}
