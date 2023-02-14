package tech.ada.web.programacao_web_2.service.impl;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.persistence.EntityNotFoundException;
import tech.ada.web.programacao_web_2.model.dto.TokenDTO;
import tech.ada.web.programacao_web_2.model.dto.UsuarioDTO;
import tech.ada.web.programacao_web_2.model.entity.Usuario;
import tech.ada.web.programacao_web_2.model.mapper.UsuarioMapper;
import tech.ada.web.programacao_web_2.repository.UsuarioRepository;
import tech.ada.web.programacao_web_2.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<UsuarioRepository, UsuarioMapper, UsuarioDTO, Usuario> implements UsuarioService {

public UsuarioServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
		super(repository, mapper);
	}

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private UsuarioMapper mapper;

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTServiceImpl jwtService;
	
	@Autowired
	private AuthServiceImpl authService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UsuarioDTO save(UsuarioDTO usuarioDTO) {
		
		Usuario usuario = mapper.parseEntity(usuarioDTO);
		usuario.setId(null);
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		
		repository.save(usuario);
		
		return mapper.parseDTO(usuario);

	}

	@Override
	public UsuarioDTO edit(Long id, UsuarioDTO usuarioDTO) {
		
		if (repository.existsById(id)) {
			
			Usuario usuario = mapper.parseEntity(usuarioDTO);
			usuario.setId(id);
			
			if (usuarioDTO.getSenha() != null) {
				usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
			} else {
				Optional<Usuario> usuarioOp = repository.findById(id);
				
				if (usuarioOp != null && usuarioOp.isPresent()) {
					usuario.setSenha(passwordEncoder.encode(usuarioOp.get().getSenha()));
				}
			}
			
			usuario = repository.save(usuario);
			
			return mapper.parseDTO(usuario);
			
		}
		
		throw new EntityNotFoundException();
		
	}
	@Override
	public TokenDTO signIn(UsuarioDTO usuarioDTO) {
		

		if (usuarioDTO != null) {
		
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuarioDTO.getUsuario(), usuarioDTO.getSenha());
			
			authManager.authenticate(authentication);
			Usuario usuario = (Usuario) authService.loadUserByUsername(usuarioDTO.getUsuario());
	
			if (usuario != null) {
								
				return generateTokenDTO(usuarioDTO.getUsuario(), mapper.parseDTO(usuario));
			}
			
		}
		
		throw new UsernameNotFoundException("Usuário não encontrado.");
		
	}
	
	@Override
	public TokenDTO refreshToken(String refreshToken) {
		
		if (refreshToken != null && jwtService.validRefreshToken(refreshToken)) {
		
			String usuario = jwtService.getUserByRefreshToken(refreshToken);
			
			return generateTokenDTO(usuario, null);
		
		}
		
		throw new ExpiredJwtException(null, null, "Token expirado.");
	}
	
	private TokenDTO generateTokenDTO(String usuario, UsuarioDTO usuarioDTO) {

		String token = jwtService.generateToken(usuario);
		String refreshToken = jwtService.generateTokenRefresh(usuario);
		
		return TokenDTO.builder()
				.token(token)
				.refreshToken(refreshToken)
				.type("Bearer")
				.user(usuarioDTO)
				.build();		
		
	}

	@Override
	public Usuario getCurrentUser(Principal principal) {

		if (principal != null) {
			
			String username = principal.getName();
			
			if (username != null) {
				
				Optional<Usuario> usuarioOp = repository.findByUsuario(username);
				
				if (usuarioOp.isPresent()) {
					
					Usuario usuario = usuarioOp.get();
					
					return usuario;
					
				}
			}
			
		}
		
		return null;
	}
	
}
