package tech.ada.web.programacao_web_2.service;

import java.util.List;

import tech.ada.web.programacao_web_2.model.dto.LivroDTO;

public interface LivroService extends IService<LivroDTO> {
	
	List<LivroDTO> findAllByCategoriaNome(String nome);

	List<LivroDTO> findAllByEditoraNome(String nome);
	
	List<LivroDTO> filter(LivroDTO livroDTO);

}
