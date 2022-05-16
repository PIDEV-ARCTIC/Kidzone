package tn.esprit.spring.entity;

import java.io.Serializable;

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

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	@Column(name="NomChauffeur")
	private String NomChauffeur;
	@Column(name="PrenomChauffeur")
	private String PrenomChauffeur;
	@Column(name="PhotoChauffeur")
	private String PhotoChauffeur;
	
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy="bus", orphanRemoval = true)
	private Set<Inscription> inscriptions;*/
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "bus",orphanRemoval = true)
	//@JsonIgnore
	//@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "bus")
	@OneToMany (mappedBy="bus", fetch = FetchType.EAGER)//,orphanRemoval = false)
	@JsonIgnore
	private Set<Inscription> inscriptions;
	 
	public Bus(Long idbus, String heuredepart, String destination, int nbrplaces, String nomChauffeur,
			String prenomChauffeur, String photoChauffeur, Set<Inscription> inscriptions) {
		super();
		this.idbus = idbus;
		this.heuredepart = heuredepart;
		this.destination = destination;
		this.nbrplaces = nbrplaces;
		this.NomChauffeur = nomChauffeur;
		this.PrenomChauffeur = prenomChauffeur;
		this.PhotoChauffeur = photoChauffeur;
		this.inscriptions = inscriptions;
	}

	
	
	public Bus(Long idbus, String heuredepart, String destination, int nbrplaces, String nomChauffeur,
			String prenomChauffeur, String photoChauffeur) {
		super();
		this.idbus = idbus;
		this.heuredepart = heuredepart;
		this.destination = destination;
		this.nbrplaces = nbrplaces;
		NomChauffeur = nomChauffeur;
		PrenomChauffeur = prenomChauffeur;
		PhotoChauffeur = photoChauffeur;
	}



	public Bus() {
		super();
	}
	

	public Bus(Long idbus) {
		super();
		this.idbus = idbus;
	}
	
	
	
	public Set<Inscription> getInscriptions() {
		return inscriptions;
	}


	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
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


	public String getNomChauffeur() {
		return NomChauffeur;
	}


	public void setNomChauffeur(String nomChauffeur) {
		NomChauffeur = nomChauffeur;
	}


	public String getPrenomChauffeur() {
		return PrenomChauffeur;
	}


	public void setPrenomChauffeur(String prenomChauffeur) {
		PrenomChauffeur = prenomChauffeur;
	}


	public String getPhotoChauffeur() {
		return PhotoChauffeur;
	}


	public void setPhotoChauffeur(String photoChauffeur) {
		PhotoChauffeur = photoChauffeur;
	}


	/*public Set<Inscription> getInscriptions() {
		return inscriptions;
	}


	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}*/
	
	
	
	
	
}
