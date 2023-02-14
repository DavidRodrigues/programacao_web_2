package tech.ada.web.programacao_web_2.service;

import java.util.List;

import tech.ada.web.programacao_web_2.model.dto.FavoritoDTO;

public interface FavoritoService {

	List<FavoritoDTO> getAll();
	
	FavoritoDTO save(FavoritoDTO favoritoDTO);
	
}
