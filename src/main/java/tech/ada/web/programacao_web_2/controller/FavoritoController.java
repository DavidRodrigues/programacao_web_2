package tech.ada.web.programacao_web_2.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.ada.web.programacao_web_2.model.dto.FavoritoDTO;
import tech.ada.web.programacao_web_2.model.dto.UsuarioDTO;
import tech.ada.web.programacao_web_2.model.entity.Usuario;
import tech.ada.web.programacao_web_2.model.mapper.UsuarioMapper;
import tech.ada.web.programacao_web_2.service.FavoritoService;
import tech.ada.web.programacao_web_2.service.UsuarioService;

@RestController
@RequestMapping("favoritos")
public class FavoritoController {

	@Autowired
	private FavoritoService service;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
		
	@GetMapping
	public ResponseEntity<List<FavoritoDTO>> getAll() {
		
		return ResponseEntity.ok(service.getAll());
		
	}
	
	@PostMapping
	public ResponseEntity<FavoritoDTO> save(@RequestBody @Valid FavoritoDTO favoritoDTO, Principal principal) {

		Usuario usuario = usuarioService.getCurrentUser(principal);
	
		UsuarioDTO usuarioDTO = usuarioMapper.parseDTO(usuario);
		
		favoritoDTO.setUsuario(usuarioDTO);
		
		return ResponseEntity.ok(service.save(favoritoDTO));
		
	}
	
}
