package tn.esprit.spring.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name= "Reglement")
public class Reglement {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idreglement;
	@Column(name="Mode")
	private String mode;
	@Column(name="DateOperation")
	private String dateoperation;
	@Column(name="SensOperation")
	private String sensoperation;
	@Column(name="Montant")
	private int montant;
	
	public Long getIdreglement() {
		return idreglement;
	}
	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getDateoperation() {
		return dateoperation;
	}
	public void setDateoperation(String dateoperation) {
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
	public Reglement(Long idreglement, String mode, String dateoperation, String sensoperation, int montant) {
		super();
		this.idreglement = idreglement;
		this.mode = mode;
		this.dateoperation = dateoperation;
		this.sensoperation = sensoperation;
		this.montant = montant;
	}
	public Reglement() {
		super();
	}
	public Reglement(Long idreglement) {
		super();
		this.idreglement = idreglement;
	}
	

	public Fournisseur getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(Fournisseur fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public void setIdreglement(Long idreglement) {
		this.idreglement = idreglement;
	}

	public Reglement(Long idreglement, String mode, String dateoperation, String sensoperation, int montant,
			Fournisseur fournisseurs) {
		super();
		this.idreglement = idreglement;
		this.mode = mode;
		this.dateoperation = dateoperation;
		this.sensoperation = sensoperation;
		this.montant = montant;
		
	}
	@ManyToOne
	Fournisseur fournisseurs;
	
	
}
