package tech.ada.web.programacao_web_2.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LivroDTO {

	private Long id;
	
	@NotNull(message="O campo editora deve estar preenchido") 
	private EditoraDTO editora;
	
	@NotNull(message="O campo categoria deve estar preenchido") 
	private CategoriaDTO categoria;
	
	@NotBlank(message="O campo nome deve estar preenchido") 
	private String nome;
	
	@NotBlank(message="O campo isbn deve estar preenchido") 
	private String isbn;
	
}
