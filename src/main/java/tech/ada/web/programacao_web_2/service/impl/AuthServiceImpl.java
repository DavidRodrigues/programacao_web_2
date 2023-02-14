package tech.ada.web.programacao_web_2.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tech.ada.web.programacao_web_2.model.entity.Usuario;
import tech.ada.web.programacao_web_2.repository.UsuarioRepository;

@Service
public class AuthServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> usuarioOp = repository.findByUsuario(username);
		
		if (usuarioOp.isPresent()) {
			
			Usuario usuario = usuarioOp.get();
			
			return usuario;
			
		}			

		throw new UsernameNotFoundException("Usuário não encontrado.");
	}

}
