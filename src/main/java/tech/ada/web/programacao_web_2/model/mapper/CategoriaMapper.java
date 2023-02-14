package tech.ada.web.programacao_web_2.model.mapper;

import org.mapstruct.Mapper;

import tech.ada.web.programacao_web_2.model.dto.CategoriaDTO;
import tech.ada.web.programacao_web_2.model.entity.Categoria;

@Mapper(componentModel="spring")
public interface CategoriaMapper extends IMapper<Categoria, CategoriaDTO> {

}
