package tn.esprit.spring.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;

@Entity ()
@Table (name= "Reglement")
public class Reglement {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idreglement;
	@Column(name="Mode")
	private String mode;
	@Column(name="DateOperation")
	private Date dateoperation;
	@Column(name="DateEche")
	private Date dateeche;
	@Column(name="SensOperation") // debit ou credit
	private String sensoperation;
	@Column(name="Montant")
	private int montant; //enfant , fournisseur, emlpoyee
	@Column(name="Type")
	private String type;
	@Column(name="Mail")
	private String mail;
	@Column(name="Idtier")
	private long idtier;
	@Column(name="NomTier")
	private String nomTier;

	
	public String getNomTier() {
		return nomTier;
	}



	public void setNomTier(String nomtier) {
		nomtier = nomTier;
	}



	public Date getDateeche() {
		return dateeche;
	}



	public void setDateeche(Date dateeche) {
		this.dateeche = dateeche;
	}



	public long getIdtier() {
		return idtier;
	}



	public void setIdtier(long idtier) {
		this.idtier = idtier;
	}



	public Long getIdreglement() {
		return idreglement;
	}
	
	

	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
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
	public Reglement(Long idreglement, String mode, Date dateoperation, String sensoperation, int montant) {
		super();
		this.idreglement = idreglement;
		this.mode = mode;
		this.dateoperation = dateoperation;
		this.sensoperation = sensoperation;
		this.montant = montant;
		
		
	}
	
	public Reglement(Long idreglement, String mode, Date dateoperation, Date dateech, String sensoperation, int montant,
			String type, String mail, long idtier) {
		super();
		this.idreglement = idreglement;
		this.mode = mode;
		this.dateoperation = dateoperation;
		this.dateeche = dateeche;
		this.sensoperation = sensoperation;
		this.montant = montant;
		this.type = type;
		this.mail = mail;
		this.idtier = idtier;
	}



	public Reglement() {
		super();
	}
	public Reglement(Long idreglement) {
		super();
		this.idreglement = idreglement;
	}
	

	

	public void setIdreglement(Long idreglement) {
		this.idreglement = idreglement;
	}

	public Reglement(Long idreglement, String mode, Date dateoperation, String sensoperation, int montant,
			Fournisseur fournisseurs) {
		super();
		this.idreglement = idreglement;
		this.mode = mode;
		this.dateoperation = dateoperation;
		this.sensoperation = sensoperation;
		this.montant = montant;
		
		
		
	}


	public Reglement(Long idreglement, String mode, Date dateoperation, String sensoperation, int montant,
			String type,String nomTier) {
		super();
		this.idreglement = idreglement;
		this.mode = mode;
		this.dateoperation = dateoperation;
		this.sensoperation = sensoperation;
		this.montant = montant;
		this.type = type;
		this.nomTier = nomTier;
		
		
	}




	

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


    


	
	
}
