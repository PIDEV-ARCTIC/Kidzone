package tn.esprit.spring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	////////////////////////////////////////
	///////////////constructors////////////
	public Employee(Long idEmployee, String nomEmployee, String prenomEmployee, String mail, String telEmployee) {
		super();
		this.idEmployee = idEmployee;
		this.nomEmployee = nomEmployee;
		this.prenomEmployee = prenomEmployee;
		this.mail = mail;
		this.telEmployee = telEmployee;
	}
	public Employee() {
		super();
	}

	///////////////////////////////////////
}
