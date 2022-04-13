package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Inscription")
public class Inscription {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idinscription;
	//@Column(name="IdEnfant")
	//private String idenfant;  clé étragère
	//@Column(name="IdEmployee")
	//private String idemployee;  clé étragère
	@Column(name="Description")
	private String description;
	@Column(name="DateOperation")
	private Date dateoperation;
	@Column(name="TypePaiement")
	private String typepaiement;
	@Column(name="Activité")
	private String activite;

}
