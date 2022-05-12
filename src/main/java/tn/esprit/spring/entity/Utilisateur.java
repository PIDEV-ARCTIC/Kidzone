package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue()
	private Long idUtilisateur;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "motDePasse")
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	@Column(name = "telephone", nullable = true)
	private String telephone;
	@OneToMany(mappedBy = "employee")
	List<Absence> abscence;
	@ManyToMany
	List<Cours> cours;
	@ManyToOne
	Jardin jardin;
	@OneToMany(mappedBy = "employee")
	List<Reglement> reglement;
	//////////// getters and setters//////////

	public Long getIdutilisateur() {
		return idUtilisateur;
	}

	public String getTelEmployee() {
		return telephone;
	}

	public void setTelEmployee(String telEmployee) {
		this.telephone = telEmployee;
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

	public List<Reglement> getReglement() {
		return reglement;
	}

	public void setReglement(List<Reglement> reglement) {
		this.reglement = reglement;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setIdutilisateur(Long idutilisateur) {
		this.idUtilisateur = idutilisateur;
	}

	public String getLogin() {
		return username;
	}

	public void setLogin(String login) {
		this.username = login;
	}

	public String getMdp() {
		return password;
	}

	public void setMdp(String mdp) {
		this.password = mdp;
	}

	//////////////////////////
	///// Constructors////////

	public Utilisateur() {
		super();
	}

	public Utilisateur(Long idutilisateur, String login, String mdp, String type) {
		super();
		this.idUtilisateur = idutilisateur;
		this.username = login;
		this.password = mdp;

	}
 
	public Utilisateur(String login, String email, String mdp) {
		super();
		this.username = login;
		this.email = email;
		this.password = mdp;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + username + ", mdp=" + password + "]";
	}

	public Utilisateur(String login, String email, String mdp, Set<Role> roles, String telEmployee,
			List<Absence> abscence, List<Cours> cours, Jardin jardin, List<Reglement> reglement) {
		super();
		this.username = login;
		this.email = email;
		this.password = mdp;
		this.roles = roles;
		this.telephone = telEmployee;
		this.abscence = abscence;
		this.cours = cours;
		this.jardin = jardin;
		this.reglement = reglement;
	}

	public Utilisateur(String login, String email, String mdp, Set<Role> roles, String telEmployee) {
		super();
		this.username = login;
		this.email = email;
		this.password = mdp;
		this.roles = roles;
		this.telephone = telEmployee;
	}

	public Utilisateur(Long idUtilisateur, String login, String email, String mdp, Set<Role> roles, String telEmployee,
			List<Absence> abscence, List<Cours> cours, Jardin jardin, List<Reglement> reglement) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.username = login;
		this.email = email;
		this.password = mdp;
		this.roles = roles;
		this.telephone = telEmployee;
		this.abscence = abscence;
		this.cours = cours;
		this.jardin = jardin;
		this.reglement = reglement;
	}

}
