package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name= "Reglement")
public class Reglement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idreglement;
	@Column(name="Mode")
	private String mode;
	@Column(name="DateOperation")
	private Date dateoperation;
	@Column(name="SensOperation")
	private String sensoperation;
	@Column(name="Montant")
	private int montant;
	
	/*@OneToOne(mappedBy="reglement")
	private Inscription inscription;*/
	
	

	/*public Reglement() {
		super();
	}



	public Reglement(Long idreglement, String mode, Date dateoperation, String sensoperation, int montant,
			Inscription inscription) {
		super();
		this.idreglement = idreglement;
		this.mode = mode;
		this.dateoperation = dateoperation;
		this.sensoperation = sensoperation;
		this.montant = montant;
		this.inscription = inscription;
	}



	public Long getIdreglement() {
		return idreglement;
	}



	public void setIdreglement(Long idreglement) {
		this.idreglement = idreglement;
	}



	public String getMode() {
		return mode;
	}



	public void setMode(String mode) {
		this.mode = mode;
	}



	public Date getDateoperation() {
		return dateoperation;
	}



	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}



	public String getSensoperation() {
		return sensoperation;
	}



	public void setSensoperation(String sensoperation) {
		this.sensoperation = sensoperation;
	}



	public int getMontant() {
		return montant;
	}



	public void setMontant(int montant) {
		this.montant = montant;
	}



	public Inscription getInscription() {
		return inscription;
	}



	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}*/
	
	
	
}
