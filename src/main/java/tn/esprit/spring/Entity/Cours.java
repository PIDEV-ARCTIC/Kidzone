package tn.esprit.spring.Entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table (name= "Cours")
public class Cours {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcours;
	//@Column(name="clé étrangère")
	//private Long idenseignant;
	
	@Column(name="Matière")
	private String matiere;
	@Column(name="Description")
	private String Description;
	@Column(name="file")
	private String file;
	
}
