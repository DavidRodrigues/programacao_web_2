package tech.ada.web.programacao_web_2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import tech.ada.web.programacao_web_2.model.entity.Usuario;
import tech.ada.web.programacao_web_2.repository.UsuarioRepository;

@Configuration
public class InitialDataConfig {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Bean
	public void inserirDados() {

		Usuario usuario = new Usuario(null, "David Santana", "david@teste.com", "admin", encoder.encode("password"), 1L);
		
		usuarioRepository.save(usuario);

	}
}
