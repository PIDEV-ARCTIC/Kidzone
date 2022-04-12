package tn.esprit.spring.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Consultation")
public class Consultation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idconsultation;
	//@Column(name="IdEnfant")
	//private String idenfant;  clé étragère
	//@Column(name="IdEmployee")
	//private String idemployee;  clé étragère
	@Column(name="Description")
	private String description;
	@Column(name="DateConsultation")
	private Date dateconsultation;
}
