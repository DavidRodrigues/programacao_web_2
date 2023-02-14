package tech.ada.web.programacao_web_2.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tech.ada.web.programacao_web_2.model.dto.UsuarioDTO;
import tech.ada.web.programacao_web_2.model.entity.Usuario;

@Mapper(componentModel="spring")
public interface UsuarioMapper extends IMapper<Usuario, UsuarioDTO> {

	@Mapping(target="senha", ignore=true)
	UsuarioDTO parseDTO(Usuario usuario);
	
	@Mapping(target="authorities",ignore=true)
	Usuario parseEntity(UsuarioDTO usuario);

}
