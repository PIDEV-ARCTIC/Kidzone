package tn.esprit.spring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Jardin")
public class Jardin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idjardin;
	@Column(name="Nom")
	private String nomjardin;
	@Column(name="Adresse")
	private String adressejardin;
	@Column(name="Logo")
	private String logo;
	@Column(name="Email")
	private String emailjardin;
	@Column(name="Telephone")
	private String numtel;
	@Column(name="tarifs")
	private int tarif;
	@Column(name="Description")
	private int description;
}