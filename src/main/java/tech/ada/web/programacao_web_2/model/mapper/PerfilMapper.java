package tech.ada.web.programacao_web_2.model.mapper;

import org.mapstruct.Mapper;

import tech.ada.web.programacao_web_2.model.dto.PerfilDTO;
import tech.ada.web.programacao_web_2.model.entity.Perfil;

@Mapper(componentModel="spring")
public interface PerfilMapper extends IMapper<Perfil, PerfilDTO> {

}
