package tech.ada.web.programacao_web_2.service.impl;

import org.springframework.stereotype.Service;

import tech.ada.web.programacao_web_2.model.dto.CategoriaDTO;
import tech.ada.web.programacao_web_2.model.entity.Categoria;
import tech.ada.web.programacao_web_2.model.mapper.CategoriaMapper;
import tech.ada.web.programacao_web_2.repository.CategoriaRepository;
import tech.ada.web.programacao_web_2.service.CategoriaService;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<CategoriaRepository, CategoriaMapper, CategoriaDTO, Categoria> implements CategoriaService {

	public CategoriaServiceImpl(CategoriaRepository repository, CategoriaMapper mapper) {
		super(repository, mapper);
	}

}
