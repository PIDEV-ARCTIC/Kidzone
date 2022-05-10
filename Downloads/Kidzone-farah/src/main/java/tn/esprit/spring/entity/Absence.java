package tn.esprit.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Absence")
public class Absence {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idabsence;
	//@Column(name="clé étrangère")
	//private Long idenseignant;
	//@Column(name="clé étrangère")
		//private Long idenfant;
	@Column(name="DateDébut")
	private Date datedebut;
	@Column(name="Periode")
	private String periode;
	@Column(name="CauseAbsence")
	private String cause;
}
