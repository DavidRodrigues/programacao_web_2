package tech.ada.web.programacao_web_2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.ada.web.programacao_web_2.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsuario(String usuario);
	
}
