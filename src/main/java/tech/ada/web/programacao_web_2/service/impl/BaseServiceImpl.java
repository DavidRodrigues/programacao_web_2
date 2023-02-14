package tech.ada.web.programacao_web_2.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import tech.ada.web.programacao_web_2.model.entity.IEntity;
import tech.ada.web.programacao_web_2.model.mapper.IMapper;
import tech.ada.web.programacao_web_2.service.IService;

public class BaseServiceImpl<R extends JpaRepository<E, Long>,
	M extends IMapper<E, T>, T, E extends IEntity> implements IService<T> {

	private R repository;
	
	private M mapper;
	
	@PersistenceContext
	private EntityManager em;
	
	public BaseServiceImpl(R repository, M mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	
	@Override
	public List<T> getAll() {

		return mapper.parseListDTO(repository.findAll());
		
	}

	@Override
	public T find(Long id) {
		
		Optional<E> entityOp = repository.findById(id);
		
		if (entityOp.isPresent()) {
			
			return mapper.parseDTO(entityOp.get());
			
		}
		
		throw new EntityNotFoundException();
	}

	@Override
	@Transactional
	public T save(T entityDTO) {

		E entity = mapper.parseEntity(entityDTO);
		entity.setId(null);
		
		repository.save(entity);
		em.refresh(entity);
		
		return mapper.parseDTO(entity);
		
	}

	@Override
	public T edit(Long id, T entityDTO) {
		
		if (repository.existsById(id)) {
			
			E entity = mapper.parseEntity(entityDTO);
			entity.setId(id);
			
			entity = repository.save(entity);
			
			return mapper.parseDTO(entity);
			
		}
		
		throw new EntityNotFoundException();
		
	}

	@Override
	public void delete(Long id) {

		if (!repository.existsById(id)) {
			
			throw new EntityNotFoundException();
			
		}
		
		repository.deleteById(id);
		
	}

}
