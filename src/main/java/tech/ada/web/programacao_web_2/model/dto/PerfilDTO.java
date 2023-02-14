package tech.ada.web.programacao_web_2.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PerfilDTO {

	private Long id;
	
	@NotBlank(message="O campo nome deve estar preenchido") 
	private String nome;
	
	private String descricao;
	
}
