package tn.esprit.spring.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Cours> cours;
}
