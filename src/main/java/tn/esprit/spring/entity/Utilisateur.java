package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idutilisateur;
	@Column(name="Login")
	private String login;
	@Column(name="MotDePasse")
	private String mdp;
	@Column(name="type")
	private String type;
}
