package tn.esprit.spring.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idemployee;
	@Column(name="Nom")
	private String nomemployee;
	@Column(name="Prenom")
	private String prenomemployee;
	@Column(name="Mail")
	private String mail;
	@Column(name="TelEmployee")
	private String telemployee;
	public Employee(Long idemployee, String nomemployee, String prenomemployee, String mail, String telemployee) {
		super();
		this.idemployee = idemployee;
		this.nomemployee = nomemployee;
		this.prenomemployee = prenomemployee;
		this.mail = mail;
		this.telemployee = telemployee;
	}
	public Long getIdemployee() {
		return idemployee;
	}
	public void setIdemployee(Long idemployee) {
		this.idemployee = idemployee;
	}
	public String getNomemployee() {
		return nomemployee;
	}
	public void setNomemployee(String nomemployee) {
		this.nomemployee = nomemployee;
	}
	public String getPrenomemployee() {
		return prenomemployee;
	}
	public void setPrenomemployee(String prenomemployee) {
		this.prenomemployee = prenomemployee;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTelemployee() {
		return telemployee;
	}
	public void setTelemployee(String telemployee) {
		this.telemployee = telemployee;
	}
	public Employee(Long idemployee) {
		super();
		this.idemployee = idemployee;
	}

	
	public Employee() {
		super();
	}


	
	
}
