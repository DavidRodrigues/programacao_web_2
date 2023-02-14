package tech.ada.web.programacao_web_2.service;

import java.security.Principal;

import tech.ada.web.programacao_web_2.model.dto.TokenDTO;
import tech.ada.web.programacao_web_2.model.dto.UsuarioDTO;
import tech.ada.web.programacao_web_2.model.entity.Usuario;

public interface UsuarioService extends IService<UsuarioDTO> {

	TokenDTO signIn(UsuarioDTO usuarioDTO);

	TokenDTO refreshToken(String refreshToken);

	Usuario getCurrentUser(Principal principal);
}
