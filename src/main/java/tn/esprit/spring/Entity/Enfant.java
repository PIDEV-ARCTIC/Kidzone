package tn.esprit.spring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Enfant")
public class Enfant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idenfant;
	@Column(name="NomEnfant")
	private String nomenfant;
	@Column(name="PrenomEnfant")
	private String prenomenfant;
	@Column(name="Age")
	private String age;
	@Column(name="Classe")
	private String classe;
	@Column(name="Photo")
	private String photo;
	@Column(name="NomParent")
	private String nomparent;
	@Column(name="PrenomParent")
	private String prenomparent;
	@Column(name="NumTel")
	private String numtel;
}
