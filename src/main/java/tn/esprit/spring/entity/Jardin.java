package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.JoinColumn;


@Entity
@Table (name= "Jardin")
public class Jardin implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
	private String description;
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy="Jardin", orphanRemoval = true)
	@OneToMany(mappedBy = "Jardin", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Enfant> enfant;
	
	public Jardin(Long idjardin, String nomjardin, String adressejardin, String logo, String emailjardin, String numtel,
			int tarif, String description, Set<Enfant> enfant) {
		super();
		this.idjardin = idjardin;
		this.nomjardin = nomjardin;
		this.adressejardin = adressejardin;
		this.logo = logo;
		this.emailjardin = emailjardin;
		this.numtel = numtel;
		this.tarif = tarif;
		this.description = description;
		this.enfant = enfant;
	}
	
	public Jardin(Long idjardin) {
		super();
		this.idjardin = idjardin;
	}
	public Jardin() {
		super();
	}
	
	public Jardin(Long idjardin, String nomjardin, String adressejardin, String logo, String emailjardin, String numtel,
			int tarif, String description) {
		super();
		this.idjardin = idjardin;
		this.nomjardin = nomjardin;
		this.adressejardin = adressejardin;
		this.logo = logo;
		this.emailjardin = emailjardin;
		this.numtel = numtel;
		this.tarif = tarif;
		this.description = description;
	}
	
	public Jardin(String nomjardin, String adressejardin, String logo, String emailjardin, String numtel, int tarif,
			String description) {
		super();
		this.nomjardin = nomjardin;
		this.adressejardin = adressejardin;
		this.logo = logo;
		this.emailjardin = emailjardin;
		this.numtel = numtel;
		this.tarif = tarif;
		this.description = description;
	}

	public Long getIdjardin() {
		return idjardin;
	}
	public void setIdjardin(Long idjardin) {
		this.idjardin = idjardin;
	}
	public String getNomjardin() {
		return nomjardin;
	}
	public void setNomjardin(String nomjardin) {
		this.nomjardin = nomjardin;
	}
	
	public String getAdressejardin() {
		return adressejardin;
	}
	public void setAdressejardin(String adressejardin) {
		this.adressejardin = adressejardin;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getEmailjardin() {
		return emailjardin;
	}
	public void setEmailjardin(String emailjardin) {
		this.emailjardin = emailjardin;
	}
	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}