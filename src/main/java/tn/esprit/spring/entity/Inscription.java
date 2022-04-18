package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@Column(name="Description")
	private String description;
	@Column(name="DateOperation")
	private Date dateoperation;
	@Column(name="TypePaiement")
	private String typepaiement;
	@Column(name="Activité")
	private String activite;
	
	@ManyToOne
	Bus bus;

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

	public String getTypepaiement() {
		return typepaiement;
	}

	public void setTypepaiement(String typepaiement) {
		this.typepaiement = typepaiement;
	}

	public String getActivite() {
		return activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Inscription(Long idinscription, String description, Date dateoperation, String typepaiement, String activite,
			Bus bus) {
		super();
		this.idinscription = idinscription;
		this.description = description;
		this.dateoperation = dateoperation;
		this.typepaiement = typepaiement;
		this.activite = activite;
		this.bus = bus;
	}
	

	public Inscription(Long idinscription) {
		super();
		this.idinscription = idinscription;
	}

	public Inscription() {
		super();
	}

	
	
	/*@ManyToOne
	Bus Bus;*/
	/*@ManyToOne(cascade = CascadeType.ALL)
	Enfant enfant;
	@OneToOne
	private Reglement reglement;*/

	
	
	
	
}
