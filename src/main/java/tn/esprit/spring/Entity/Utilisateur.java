package tn.esprit.spring.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Utilisateur")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue()
	private Long idUtilisateur;
	@Column(name="Login")
	private String login;
	@Column(name="motDePasse")
	private String mdp;
	@Column(name="type")
	private String type;
	////////////getters and setters//////////
	public Long getIdutilisateur() {
		return idUtilisateur;
	}
	public void setIdutilisateur(Long idutilisateur) {
		this.idUtilisateur = idutilisateur;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//////////////////////////
	/////Constructors////////
	public Utilisateur(Long idutilisateur, String login, String mdp, String type) {
		super();
		this.idUtilisateur = idutilisateur;
		this.login = login;
		this.mdp = mdp;
		this.type = type;
	}
	public Utilisateur() {
		super();
	}

}
