package tech.ada.web.programacao_web_2.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioLoginDTO {

	private String usuario;
	
	private String senha;
	
}
