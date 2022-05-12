package tn.esprit.spring.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.spring.entity.Utilisateur;;





@NoArgsConstructor 
@Entity
@Table (name= "Reclamation")
public class Reclamation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idreclamation;
	@Column(name="TypeReclamation")
	@Enumerated(EnumType.STRING)
    private type typereclamation; 
	
	public Long getIdreclamation() {
		return idreclamation;
	}

	public void setIdreclamation(Long idreclamation) {
		this.idreclamation = idreclamation;
	}

	public type getTypereclamation() {
		return typereclamation;
	}

	public void setTypereclamation(type typereclamation) {
		this.typereclamation = typereclamation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name="Description")
	private String description;
	@Column(name="Nom")
	private String nom;
	@Column(name="mail")
	private String mail;
	
	@JsonIgnore
	@ManyToOne
	Utilisateur user ;
	
}