package tech.ada.web.programacao_web_2.model.mapper;

import org.mapstruct.Mapper;

import tech.ada.web.programacao_web_2.model.dto.LivroDTO;
import tech.ada.web.programacao_web_2.model.entity.Livro;

@Mapper(componentModel="spring")
public interface LivroMapper extends IMapper<Livro, LivroDTO> {

}
