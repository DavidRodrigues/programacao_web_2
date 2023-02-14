package tech.ada.web.programacao_web_2.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="livros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro implements IEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@JoinColumn(name="editora_id", nullable=false)
	@ManyToOne(fetch=FetchType.EAGER)
	private Editora editora;
	
	@JoinColumn(name="categoria_id", nullable=false)
	@ManyToOne(fetch=FetchType.EAGER)
	private Categoria categoria;
	
	@Column(columnDefinition="TEXT")
	private String nome;
	
	@Column(length=13)
	private String isbn;
	
}
