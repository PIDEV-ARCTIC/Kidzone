package tn.esprit.spring.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy="cours", cascade = CascadeType.ALL)
	private Set<Employee> Employees;
	
}
