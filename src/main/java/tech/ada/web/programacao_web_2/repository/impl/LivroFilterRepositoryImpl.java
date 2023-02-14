package tech.ada.web.programacao_web_2.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import tech.ada.web.programacao_web_2.model.entity.Livro;
import tech.ada.web.programacao_web_2.repository.LivroFilterRepository;

@Repository
public class LivroFilterRepositoryImpl implements LivroFilterRepository {

	@Autowired
	private EntityManager em;
	
	@Transactional
	@Override
	public List<Livro> filter(Livro livro) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Livro> cq = cb.createQuery(Livro.class);
		
		Root<Livro> root = cq.from(Livro.class);
		List<Predicate> predicates = new ArrayList<>();
		
		if (livro != null) {
			
			if (livro.getNome() != null && !livro.getNome().isBlank()) {

				predicates.add(cb.like(cb.upper(root.get("nome")), "%" + livro.getNome().toUpperCase() + "%"));
				
			}
			
			if (livro.getIsbn() != null && !livro.getIsbn().isBlank()) {

				predicates.add(cb.like(cb.upper(root.get("isbn")), "%" + livro.getIsbn().toUpperCase() + "%"));
				
			}
		
			//cq.where(cb.or(predicates.toArray(new Predicate[0])));
			cq.where(predicates.toArray(new Predicate[0]));
			
			List<Livro> livros = em.createQuery(cq).getResultList();
			
			return livros;
			
		}
		
		return new ArrayList<Livro>();
	}

}
