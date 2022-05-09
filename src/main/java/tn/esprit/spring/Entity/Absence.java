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
@Table (name= "Absence")
public class Absence {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idabsence;
	//@Column(name="clé étrangère")
	//private Long idenseignant;
	//@Column(name="clé étrangère")
		//private Long idenfant;
	@Column(name="DateDébut")
	private Date datedebut;
	@Column(name="Periode")
	private String periode;
	@Column(name="CauseAbsence")
	private String cause;
	@ManyToOne
	Utilisateur employee;
	/////////////getters and setters/////
	public Long getIdabsence() {
		return idabsence;
	}
	public void setIdabsence(Long idabsence) {
		this.idabsence = idabsence;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public Utilisateur getEmployee() {
		return employee;
	}
	public void setEmployee(Utilisateur employee) {
		this.employee = employee;
	}
	////////////////////////////////
	////////////////constructors////
	public Absence(Long idabsence, Date datedebut, String periode, String cause, Utilisateur employee) {
		super();
		this.idabsence = idabsence;
		this.datedebut = datedebut;
		this.periode = periode;
		this.cause = cause;
		this.employee = employee;
	}
	public Absence() {
		super();
	}
	
}
