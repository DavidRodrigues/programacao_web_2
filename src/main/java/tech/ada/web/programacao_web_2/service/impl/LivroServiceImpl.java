package tech.ada.web.programacao_web_2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.ada.web.programacao_web_2.model.dto.LivroDTO;
import tech.ada.web.programacao_web_2.model.entity.Livro;
import tech.ada.web.programacao_web_2.model.mapper.LivroMapper;
import tech.ada.web.programacao_web_2.repository.LivroRepository;
import tech.ada.web.programacao_web_2.service.LivroService;

@Service
public class LivroServiceImpl extends BaseServiceImpl<LivroRepository, LivroMapper, LivroDTO, Livro> implements LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private LivroMapper mapper;

	public LivroServiceImpl(LivroRepository repository, LivroMapper mapper) {
		super(repository, mapper);
	}

	@Override
	public List<LivroDTO> findAllByCategoriaNome(String nome) {

		List<Livro> livros = repository.findAllByCategoriaNome(nome);
		
		return mapper.parseListDTO(livros);
		
	}

	@Override
	public List<LivroDTO> findAllByEditoraNome(String nome) {

		List<Livro> livros = repository.findAllByEditoraNome(nome);
		
		return mapper.parseListDTO(livros);
		
	}

	@Override
	public List<LivroDTO> filter(LivroDTO livroDTO) {
		
		Livro livro = mapper.parseEntity(livroDTO);
		
		List<Livro> livros = repository.filter(livro);
		
		return mapper.parseListDTO(livros);

	}
	
}
