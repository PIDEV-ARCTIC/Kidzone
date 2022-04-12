package tn.esprit.spring.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table (name= "Reclamation")
public class Reclamation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idreclamation;
	@Column(name="TypeReclamation")
	@Enumerated(EnumType.STRING)
    private type typereclamation; 
	
	@Column(name="Description")
	private String description;
	@Column(name="Nom")
	private String nom;
	
	//idutilisateur clé étrangère à ajouter 
}
