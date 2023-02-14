package tech.ada.web.programacao_web_2.service.impl;

import org.springframework.stereotype.Service;

import tech.ada.web.programacao_web_2.model.dto.EditoraDTO;
import tech.ada.web.programacao_web_2.model.entity.Editora;
import tech.ada.web.programacao_web_2.model.mapper.EditoraMapper;
import tech.ada.web.programacao_web_2.repository.EditoraRepository;
import tech.ada.web.programacao_web_2.service.EditoraService;

@Service
public class EditoraServiceImpl extends BaseServiceImpl<EditoraRepository, EditoraMapper, EditoraDTO, Editora> implements EditoraService {

	public EditoraServiceImpl(EditoraRepository repository, EditoraMapper mapper) {
		super(repository, mapper);
	}

}
