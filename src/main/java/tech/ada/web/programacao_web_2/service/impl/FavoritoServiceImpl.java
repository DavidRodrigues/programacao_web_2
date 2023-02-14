package tech.ada.web.programacao_web_2.service.impl;

import org.springframework.stereotype.Service;

import tech.ada.web.programacao_web_2.model.dto.FavoritoDTO;
import tech.ada.web.programacao_web_2.model.entity.Favorito;
import tech.ada.web.programacao_web_2.model.mapper.FavoritoMapper;
import tech.ada.web.programacao_web_2.repository.FavoritoRepository;
import tech.ada.web.programacao_web_2.service.FavoritoService;

@Service
public class FavoritoServiceImpl extends BaseServiceImpl<FavoritoRepository, FavoritoMapper, FavoritoDTO, Favorito> implements FavoritoService {

	public FavoritoServiceImpl(FavoritoRepository repository, FavoritoMapper mapper) {
		super(repository, mapper);
	}
	
}
