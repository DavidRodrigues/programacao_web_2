package tech.ada.web.programacao_web_2.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="editoras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editora implements IEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nome", nullable=false, length=255)
	private String nome;
	
	@Column(name="descricao", columnDefinition="TEXT")
	private String descricao;
	
}
