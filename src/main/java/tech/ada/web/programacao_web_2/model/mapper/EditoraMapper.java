package tech.ada.web.programacao_web_2.model.mapper;


import org.mapstruct.Mapper;

import tech.ada.web.programacao_web_2.model.dto.EditoraDTO;
import tech.ada.web.programacao_web_2.model.entity.Editora;

@Mapper(componentModel="spring")
public interface EditoraMapper extends IMapper<Editora, EditoraDTO> {

	
	
}
