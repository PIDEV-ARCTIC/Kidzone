package tn.esprit.spring.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Fournisseur")
public class Fournisseur {
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
	private String telfournissuer;
	@Column(name="Domaine")
	private String domaine;
}
