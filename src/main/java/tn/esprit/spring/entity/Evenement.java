package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name= "Evenement")
public class Evenement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idevenement;
	//@Column(name="IdEnfant")
	//private String idenfant;  clé étragère

	@Column(name="Description")
	private String description;
	@Column(name="Type")
	private String type;
	
	@OneToOne
	private Imagen image;

	
	@ManyToOne
	Jardin jardin;


	public Evenement() {
		super();
	}


	public Evenement(Long idevenement, String description, String type, Imagen image, Jardin jardin) {
		super();
		this.idevenement = idevenement;
		this.description = description;
		this.type = type;
		this.image = image;
		this.jardin = jardin;
	}


	public Long getIdevenement() {
		return idevenement;
	}


	public void setIdevenement(Long idevenement) {
		this.idevenement = idevenement;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Imagen getImage() {
		return image;
	}


	public void setImage(Imagen image) {
		this.image = image;
	}


	public Jardin getJardin() {
		return jardin;
	}


	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}


	@Override
	public String toString() {
		return "Evenement [idevenement=" + idevenement + ", description=" + description + ", type=" + type + ", image="
				+ image + ", jardin=" + jardin + "]";
	}







	
	
	
}
