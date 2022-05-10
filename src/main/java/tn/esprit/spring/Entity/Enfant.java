package tn.esprit.spring.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "Enfant")
public class Enfant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idenfant;
	@Column(name="NomEnfant")
	private String nomenfant;
	@Column(name="PrenomEnfant")
	private String prenomenfant;
	@Column(name="Age")
	private String age;
	@Column(name="Classe")
	private String classe;
	@Column(name="Photo")
	private String photo;
	@Column(name="NomParent")
	private String nomparent;
	@Column(name="PrenomParent")
	private String prenomparent;
	@Column(name="NumTel")
	private String numtel;
	@Column(name="Email")
	private String mail;
	public Enfant(Long idenfant, String nomenfant, String prenomenfant, String age, String classe, String photo,
			String nomparent, String prenomparent, String numtel) {
		super();
		this.idenfant = idenfant;
		this.nomenfant = nomenfant;
		this.prenomenfant = prenomenfant;
		this.age = age;
		this.classe = classe;
		this.photo = photo;
		this.nomparent = nomparent;
		this.prenomparent = prenomparent;
		this.numtel = numtel;
	}
	public Long getIdenfant() {
		return idenfant;
	}
	public void setIdenfant(Long idenfant) {
		this.idenfant = idenfant;
	}
	public String getNomenfant() {
		return nomenfant;
	}
	public void setNomenfant(String nomenfant) {
		this.nomenfant = nomenfant;
	}
	public String getPrenomenfant() {
		return prenomenfant;
	}
	public void setPrenomenfant(String prenomenfant) {
		this.prenomenfant = prenomenfant;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNomparent() {
		return nomparent;
	}
	public void setNomparent(String nomparent) {
		this.nomparent = nomparent;
	}
	public String getPrenomparent() {
		return prenomparent;
	}
	public void setPrenomparent(String prenomparent) {
		this.prenomparent = prenomparent;
	}
	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	public Enfant(Long idenfant) {
		super();
		this.idenfant = idenfant;
	}

	public Enfant(Long idenfant, String nomenfant, String prenomenfant, String age, String classe, String photo,
			String nomparent, String prenomparent, String numtel, String mail) {
		super();
		this.idenfant = idenfant;
		this.nomenfant = nomenfant;
		this.prenomenfant = prenomenfant;
		this.age = age;
		this.classe = classe;
		this.photo = photo;
		this.nomparent = nomparent;
		this.prenomparent = prenomparent;
		this.numtel = numtel;
		this.mail = mail;
		
	}
	
	public Enfant() {
		super();
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
