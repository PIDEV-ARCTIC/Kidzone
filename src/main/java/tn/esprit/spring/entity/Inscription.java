package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.beust.jcommander.internal.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
@Entity
@Table (name= "Inscription")
public class Inscription implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idinscription;
	@Column(name="DateOperation")
	private Date dateoperation;
	@Column(name="Montant")
	private int montant;
	@Column(name="TypePaiement")
	private Boolean typepaiement;
	@Column(name="Activité")
	private Boolean activite;
	@Column(name="Description")
	private String description;
	
	
//	@ManyToOne (fetch=FetchType.EAGER)
	//@JoinColumn(name = "bus_idbus", nullable = true)
	//@JsonIgnore
	//Bus bus;
	/*@ManyToOne
	Enfant enfant;*/
	@OneToOne
	private Enfant enfant;


	
	public Inscription(Date dateoperation, Enfant enfant) {
		super();
		this.dateoperation = dateoperation;
		this.enfant = enfant;
	}


	public Inscription(Long idinscription, Date dateoperation, int montant, Boolean typepaiement, Boolean activite,
			String description) {
		super();
		this.idinscription = idinscription;
		this.dateoperation = dateoperation;
		this.montant = montant;
		this.typepaiement = typepaiement;
		this.activite = activite;
		this.description = description;
	}


	public Inscription(Long idinscription) {
		super();
		this.idinscription = idinscription;
	}
	
	

	public Inscription(Date dateoperation) {
		super();
		this.dateoperation = dateoperation;
	}


	public Inscription() {
		super();
	}

	public Long getIdinscription() {
		return idinscription;
	}

	public void setIdinscription(Long idinscription) {
		this.idinscription = idinscription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateoperation() {
		return dateoperation;
	}

	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public Boolean getTypepaiement() {
		return typepaiement;
	}

	public void setTypepaiement(Boolean typepaiement) {
		this.typepaiement = typepaiement;
	}

	public Boolean getActivite() {
		return activite;
	}

	public void setActivite(Boolean activite) {
		this.activite = activite;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	
	
}