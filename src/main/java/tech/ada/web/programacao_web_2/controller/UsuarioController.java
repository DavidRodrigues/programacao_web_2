package tech.ada.web.programacao_web_2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.ada.web.programacao_web_2.model.dto.TokenDTO;
import tech.ada.web.programacao_web_2.model.dto.UsuarioDTO;
import tech.ada.web.programacao_web_2.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BaseController<UsuarioDTO, UsuarioService> {
	
	public UsuarioController(UsuarioService service) {
		super(service);
	}

	@PostMapping("/auth")
	public ResponseEntity<TokenDTO> auth(@RequestBody @Valid UsuarioDTO usuarioDTO) {
		
		return ResponseEntity.ok(service.signIn(usuarioDTO));
		
	}
	
	@GetMapping("/auth/{refreshToken}")
	public ResponseEntity<TokenDTO> refresh(@PathVariable("refreshToken") String refreshToken) {
		
		return ResponseEntity.ok(service.refreshToken(refreshToken));
		
	}
	
}
