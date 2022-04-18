package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
@Entity
@Table (name= "Bus")
public class Bus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idbus;
	@Column(name="HeureDépart")
	private String heuredepart;
	@Column(name="Destination")
	private String destination;
	@Column(name="NbrPlaces")
	private int nbrplaces;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="bus",orphanRemoval=true)
	private Set<Inscription> inscriptions;

	public Bus(Long idbus, String heuredepart, String destination, int nbrplaces, Set<Inscription> inscriptions) {
		super();
		this.idbus = idbus;
		this.heuredepart = heuredepart;
		this.destination = destination;
		this.nbrplaces = nbrplaces;
		this.inscriptions = inscriptions;
	}

	public Bus() {
		super();
	}
	

	public Bus(Long idbus) {
		super();
		this.idbus = idbus;
	}

	public Long getIdbus() {
		return idbus;
	}

	public void setIdbus(Long idbus) {
		this.idbus = idbus;
	}

	public String getHeuredepart() {
		return heuredepart;
	}

	public void setHeuredepart(String heuredepart) {
		this.heuredepart = heuredepart;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNbrplaces() {
		return nbrplaces;
	}

	public void setNbrplaces(int nbrplaces) {
		this.nbrplaces = nbrplaces;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
