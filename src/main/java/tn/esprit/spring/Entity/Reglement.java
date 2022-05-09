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
	@ManyToOne
	Utilisateur employee;
	///////////getters and setters ////////////
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
	public Utilisateur getEmployee() {
		return employee;
	}
	public void setEmployee(Utilisateur employee) {
		this.employee = employee;
	}
	//////////////////////////////////
	/////////constructos///////////////
	public Reglement(Long idreglement, String mode, Date dateoperation, String sensoperation, int montant,
			Utilisateur employee) {
		super();
		this.idreglement = idreglement;
		this.mode = mode;
		this.dateoperation = dateoperation;
		this.sensoperation = sensoperation;
		this.montant = montant;
		this.employee = employee;
	}
	public Reglement() {
		super();
	}
	
}
