package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Evenement")
public class Evenement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevenement;
	//@Column(name="IdEnfant")
	//private String idenfant;  clé étragère
	@Column(name="Image")
	private String image;
	@Column(name="Description")
	private String description;
	
}
