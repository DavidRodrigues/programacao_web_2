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
@Table(name="favoritos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favorito implements IEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@JoinColumn(name="usuario_id", nullable=false)
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario usuario;
	
	@JoinColumn(name="livro_id", nullable=false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Livro livro;
	
}
