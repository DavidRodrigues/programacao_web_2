package tech.ada.web.programacao_web_2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tech.ada.web.programacao_web_2.model.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>, LivroFilterRepository {

	@Query(value="SELECT l FROM Livro l JOIN l.categoria c WHERE UPPER(c.nome) LIKE CONCAT('%',UPPER(:nome),'%')")
	List<Livro> findAllByCategoriaNome(@Param("nome") String nome);

	@Query(value="SELECT l FROM Livro l JOIN l.editora c WHERE UPPER(c.nome) LIKE CONCAT('%',UPPER(:nome),'%')")
	List<Livro> findAllByEditoraNome(@Param("nome") String nome);
	
}
