package tn.esprit.spring.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.JoinColumn;


@Entity
@Table (name= "Enfant")
public class Enfant implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
	@Column(name="gender")
	private String gender;
	@Column(name="NomPrenomParent")
	private String nomprenomparent;
	@Column(name="NumTel")
	private String numtel;
	@Column(name="MailParent")
	private String mail;
	@Column(name="AdresseE")
	private String adresseEnfant;
	@JsonIgnore
	@Column(name = "qrCodeImage")
	private String qrCodeImageEnfant;
	@ManyToOne
	//@JoinTable(name = "enfant_Jardin",joinColumns = @JoinColumn(name = "idenfant_enfant"),inverseJoinColumns = @JoinColumn(name = "idjardin_jardin"))
	Jardin Jardin;
	@JsonIgnore
	@OneToOne(mappedBy="enfant",cascade = CascadeType.ALL, orphanRemoval=true)
	private Inscription inscription;
	
	public Enfant() {
		super();
	}
    

public Enfant(Long idenfant) {
		super();
		this.idenfant = idenfant;
	}


public Enfant(Long idenfant, String nomenfant, String prenomenfant, String age, String classe, String photo,
			String gender, String nomprenomparent, String numtel, String mail, String adresseEnfant,
			String qrCodeImageEnfant, tn.esprit.spring.entity.Jardin jardin, Inscription inscription) {
		super();
		this.idenfant = idenfant;
		this.nomenfant = nomenfant;
		this.prenomenfant = prenomenfant;
		this.age = age;
		this.classe = classe;
		this.photo = photo;
		this.gender = gender;
		this.nomprenomparent = nomprenomparent;
		this.numtel = numtel;
		this.mail = mail;
		this.adresseEnfant = adresseEnfant;
		this.qrCodeImageEnfant = qrCodeImageEnfant;
		Jardin = jardin;
		this.inscription = inscription;
	}


public Enfant(String nomenfant, String prenomenfant, String adresseEnfant, String age, String classe, String photo,
			String nomprenomparent, String numtel, String gender, String mail, String qrCodeImageEnfant,
			tn.esprit.spring.entity.Jardin jardin) {
		super();
		this.nomenfant = nomenfant;
		this.prenomenfant = prenomenfant;
		this.age = age;
		this.classe = classe;
		this.photo = photo;
		this.gender = gender;
		this.nomprenomparent = nomprenomparent;
		this.numtel = numtel;
		this.mail = mail;
		this.adresseEnfant = adresseEnfant;
		this.qrCodeImageEnfant = qrCodeImageEnfant;
		Jardin = jardin;
	}




	public Enfant(Long idenfant, String nomenfant, String prenomenfant, String age, String classe, String photo,
			String gender, String nomprenomparent, String numtel, String mail, String adresseEnfant,
			String qrCodeImageEnfant, tn.esprit.spring.entity.Jardin jardin) {
		super();
		this.idenfant = idenfant;
		this.nomenfant = nomenfant;
		this.prenomenfant = prenomenfant;
		this.age = age;
		this.classe = classe;
		this.photo = photo;
		this.gender = gender;
		this.nomprenomparent = nomprenomparent;
		this.numtel = numtel;
		this.mail = mail;
		this.adresseEnfant = adresseEnfant;
		this.qrCodeImageEnfant = qrCodeImageEnfant;
		Jardin = jardin;
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









	public String getGender() {
		return gender;
	}









	public void setGender(String gender) {
		this.gender = gender;
	}









	public String getNomprenomparent() {
		return nomprenomparent;
	}









	public void setNomprenomparent(String nomprenomparent) {
		this.nomprenomparent = nomprenomparent;
	}









	public String getNumtel() {
		return numtel;
	}









	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}









	public String getMail() {
		return mail;
	}









	public void setMail(String mail) {
		this.mail = mail;
	}









	public String getAdresseEnfant() {
		return adresseEnfant;
	}









	public void setAdresseEnfant(String adresseEnfant) {
		this.adresseEnfant = adresseEnfant;
	}









	public Jardin getJardin() {
		return Jardin;
	}









	public void setJardin(Jardin jardin) {
		Jardin = jardin;
	}









	public String getQrCodeImageEnfant() {
		return qrCodeImageEnfant;
	}









	public void setQrCodeImageEnfant(String qrCodeImageEnfant) {
		this.qrCodeImageEnfant = qrCodeImageEnfant;
	}





	
	
	
}
