package tn.esprit.spring.Entity;

import java.util.List;
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
@Table (name= "Fournisseur")
public class Fournisseur {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idfournisseur;
	@Column(name="NomFournisseur")
	private String nomfournisseur;
	@Column(name="PrenomFournisseur")
	private String prenomfournisseur;
	@Column(name="MailFournisseur")
	private String mailfournisseur;
	@Column(name="TelFournisseur")
	private String telfournisseur;
	@Column(name="Domaine")
	private String domaine;
	public Long getIdfournisseur() {
		return idfournisseur;
	}
	public String getNomfournisseur() {
		return nomfournisseur;
	}
	public void setNomfournisseur(String nomfournisseur) {
		this.nomfournisseur = nomfournisseur;
	}
	public String getPrenomfournisseur() {
		return prenomfournisseur;
	}
	public void setPrenomfournisseur(String prenomfournisseur) {
		this.prenomfournisseur = prenomfournisseur;
	}
	public String getMailfournisseur() {
		return mailfournisseur;
	}
	public void setMailfournisseur(String mailfournisseur) {
		this.mailfournisseur = mailfournisseur;
	}
	public String getTelfournisseur() {
		return telfournisseur;
	}
	public void setTelfournisseur(String telfournisseur) {
		this.telfournisseur = telfournisseur;
	}
	public String getDomaine() {
		return domaine;
	}
	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
	public Fournisseur(Long idfournisseur, String nomfournisseur, String prenomfournisseur, String mailfournisseur,
			String telfournisseur, String domaine) {
		super();
		this.idfournisseur = idfournisseur;
		this.nomfournisseur = nomfournisseur;
		this.prenomfournisseur = prenomfournisseur;
		this.mailfournisseur = mailfournisseur;
		this.telfournisseur = telfournisseur;
		this.domaine = domaine;
	}
	public Fournisseur() {
		super();
	}
	public Fournisseur(Long idfournisseur) {
		super();
		this.idfournisseur = idfournisseur;
	}
	
	
	
	
	
}