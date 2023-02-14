package tech.ada.web.programacao_web_2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.ada.web.programacao_web_2.model.dto.LivroDTO;
import tech.ada.web.programacao_web_2.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController extends BaseController<LivroDTO, LivroService> {

	public LivroController(LivroService service) {
		super(service);
	}
	
	@GetMapping("/filter/categoria/{nome}")
	public ResponseEntity<List<LivroDTO>> findByCategoriaNome(@PathVariable("nome") String nome) {
		
		return ResponseEntity.ok(service.findAllByCategoriaNome(nome));
		
	}
	
	@GetMapping("/filter/editora/{nome}")
	public ResponseEntity<List<LivroDTO>> findByEditoraNome(@PathVariable("nome") String nome) {
		
		return ResponseEntity.ok(service.findAllByEditoraNome(nome));
		
	}
	
	@PostMapping("/filter")
	public ResponseEntity<List<LivroDTO>> filter(@RequestBody LivroDTO livroDTO) {

		return ResponseEntity.ok(service.filter(livroDTO));
		
	}
}
