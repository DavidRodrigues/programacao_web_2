package tech.ada.web.programacao_web_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.ada.web.programacao_web_2.model.entity.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Long>{

}
