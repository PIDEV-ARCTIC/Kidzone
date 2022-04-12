package tn.esprit.spring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Bus")
public class Transport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbus;
	@Column(name="HeureDépart")
	private String heuredepart;
	@Column(name="Destination")
	private String destination;
	@Column(name="NbrPlaces")
	private String nbrplaces;
}
