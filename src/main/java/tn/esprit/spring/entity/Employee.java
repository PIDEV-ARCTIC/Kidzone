package tn.esprit.spring.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name= "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEmployee;
	@Column(name="Nom")
	private String nomEmployee;
	@Column(name="Prenom")
	private String prenomEmployee;
	@Column(name="Mail")
	private String mail;
	@Column(name="TelEmployee")
	private String telEmployee;
	@OneToMany(mappedBy="employee")
	List<Absence> abscence;
	@ManyToMany
List<Cours> cours;
	@ManyToOne
	Jardin jardin;
//	@OneToMany(mappedBy="employee")
	//List<Reglement> reglement;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="employee",fetch = FetchType.EAGER)
	private Set<Absence> absences;
	///////////////getters and setters//////
	public Long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
	}
	public String getNomEmployee() {
		return nomEmployee;
	}
	public void setNomEmployee(String nomEmployee) {
		this.nomEmployee = nomEmployee;
	}
	public String getPrenomEmployee() {
		return prenomEmployee;
	}
	public void setPrenomEmployee(String prenomEmployee) {
		this.prenomEmployee = prenomEmployee;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelEmployee() {
		return telEmployee;
	}
	public void setTelEmployee(String telEmployee) {
		this.telEmployee = telEmployee;
	}
	public List<Absence> getAbscence() {
		return abscence;
	}
	public void setAbscence(List<Absence> abscence) {
		this.abscence = abscence;
	}
	public List<Cours> getCours() {
		return cours;
	}
	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}
	public Jardin getJardin() {
		return jardin;
	}
	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}
/*	public List<Reglement> getReglement() {
		return reglement;
	}
	public void setReglement(List<Reglement> reglement) {
		this.reglement = reglement;
	}
	*/
	//////////////////////////////
	///////constructors//////////
	public Employee(Long idEmployee, String nomEmployee, String prenomEmployee, String mail, String telEmployee,
			List<Absence> abscence, List<Cours> cours, Jardin jardin) {
		super();
		this.idEmployee = idEmployee;
		this.nomEmployee = nomEmployee;
		this.prenomEmployee = prenomEmployee;
		this.mail = mail;
		this.telEmployee = telEmployee;
		this.abscence = abscence;
		this.cours = cours;
		this.jardin = jardin;
		//this.reglement = reglement;
	}
	public Employee() {
		super();
	}
	
}