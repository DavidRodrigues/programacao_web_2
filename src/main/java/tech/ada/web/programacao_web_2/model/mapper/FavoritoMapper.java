package tech.ada.web.programacao_web_2.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tech.ada.web.programacao_web_2.model.dto.FavoritoDTO;
import tech.ada.web.programacao_web_2.model.entity.Favorito;

@Mapper(componentModel="spring")
public interface FavoritoMapper extends IMapper<Favorito, FavoritoDTO> {

	@Mapping(target = "usuario.senha", ignore = true)
	FavoritoDTO parseDTO(Favorito favoritos);
	
	@Mapping(target = "usuario.authorities", ignore = true)	
	Favorito parseEntity(FavoritoDTO favoritos);

}
