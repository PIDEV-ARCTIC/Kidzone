package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Cours")
public class Cours {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcours;
	//@Column(name="clé étrangère")
	//private Long idenseignant;
	@Column(name="Date")
	private Date datedebutcours;
	@Column(name="Matière")
	private String matiere;
}
