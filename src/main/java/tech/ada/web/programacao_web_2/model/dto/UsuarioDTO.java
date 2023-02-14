package tech.ada.web.programacao_web_2.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioDTO {

	private Long id;
	
	private String nome;
	
	private String email;
	
	private String usuario;
	
	private String senha;
	
	private Long perfil;
	
}
