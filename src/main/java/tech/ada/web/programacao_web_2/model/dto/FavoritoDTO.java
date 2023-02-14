package tech.ada.web.programacao_web_2.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FavoritoDTO {

	private Long id;
	
	private UsuarioDTO usuario;
	
	@NotNull(message="O campo livro deve estar preenchido") 
	private LivroDTO livro;

}
