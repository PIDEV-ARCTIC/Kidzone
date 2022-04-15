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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 


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
	@OneToMany(cascade = CascadeType.ALL , mappedBy= "user")
	private Set<Reclamation> Reclamations;
}
