package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Reclamation")
public class Reclamation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idreclamation;
	@Column(name="TypeReclamation")
	private String typereclamation;
	@Column(name="Description")
	private String description;
	//idutilisateur clé étrangère à ajouter 
}
