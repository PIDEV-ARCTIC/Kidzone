package tn.esprit.spring.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name= "Cours")
public class Cours {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idcours;
	//@Column(name="clé étrangère")
	//private Long idenseignant;
	@Column(name="Date")
	private Date datedebutcours;
	@Column(name="Matière")
	private String matiere;
	@ManyToMany
	List<Employee> employee;
	//////////////////getters and setters///////////
	public Long getIdcours() {
		return idcours;
	}
	public void setIdcours(Long idcours) {
		this.idcours = idcours;
	}
	public Date getDatedebutcours() {
		return datedebutcours;
	}
	public void setDatedebutcours(Date datedebutcours) {
		this.datedebutcours = datedebutcours;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	/////////////////////////////
	///////constructors//////////
	public Cours(Long idcours, Date datedebutcours, String matiere, List<Employee> employee) {
		super();
		this.idcours = idcours;
		this.datedebutcours = datedebutcours;
		this.matiere = matiere;
		this.employee = employee;
	}
	public Cours() {
		super();
	}
	
}
