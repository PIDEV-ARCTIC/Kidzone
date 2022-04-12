package tn.esprit.spring.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "Consultation")
public class Consultation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idConsultation;
	//@Column(name="IdEnfant")
	//private String idenfant;  clé étragère
	//@Column(name="IdEmployee")
	//private String idemployee;  clé étragère
	@Column(name="Description")
	private String description;
	@Column(name="dateConsultation")
	private Date dateConsultation;
	///////////////getters and setters////////
	public Long getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(Long idConsultation) {
		this.idConsultation = idConsultation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateConsultation() {
		return dateConsultation;
	}
	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}
	
	
	/////////////////////////////////////////
	///////////////constructors/////////////
	public Consultation(Long idConsultation, String description, Date dateConsultation) {
		super();
		this.idConsultation = idConsultation;
		this.description = description;
		this.dateConsultation = dateConsultation;
	}
	public Consultation() {
		super();
	}
	
	///////////////////////////////////////
}
