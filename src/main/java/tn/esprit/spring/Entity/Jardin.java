package tn.esprit.spring.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "Jardin")
public class Jardin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idjardin;
	@Column(name="Nom")
	private String nomjardin;
	@Column(name="Adresse")
	private String adressejardin;
	@Column(name="Logo")
	private String logo;
	@Column(name="Email")
	private String emailjardin;
	@Column(name="Telephone")
	private String numtel;
	@Column(name="tarifs")
	private int tarif;
	@Column(name="Description")
	private int description;
	@OneToMany(mappedBy="jardin")
	List<Employee> employee;
	/////////////////////getters and setters/////////
	public Long getIdjardin() {
		return idjardin;
	}
	public void setIdjardin(Long idjardin) {
		this.idjardin = idjardin;
	}
	public String getNomjardin() {
		return nomjardin;
	}
	public void setNomjardin(String nomjardin) {
		this.nomjardin = nomjardin;
	}
	public String getAdressejardin() {
		return adressejardin;
	}
	public void setAdressejardin(String adressejardin) {
		this.adressejardin = adressejardin;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getEmailjardin() {
		return emailjardin;
	}
	public void setEmailjardin(String emailjardin) {
		this.emailjardin = emailjardin;
	}
	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	public int getDescription() {
		return description;
	}
	public void setDescription(int description) {
		this.description = description;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	//////////////////////
	/////constructors////
	public Jardin(Long idjardin, String nomjardin, String adressejardin, String logo, String emailjardin, String numtel,
			int tarif, int description, List<Employee> employee) {
		super();
		this.idjardin = idjardin;
		this.nomjardin = nomjardin;
		this.adressejardin = adressejardin;
		this.logo = logo;
		this.emailjardin = emailjardin;
		this.numtel = numtel;
		this.tarif = tarif;
		this.description = description;
		this.employee = employee;
	}
	public Jardin() {
		super();
	}
	
}