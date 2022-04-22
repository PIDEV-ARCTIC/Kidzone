package tn.esprit.spring.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.JoinColumn;


@Entity
@Table (name= "Enfant")
public class Enfant implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idenfant;
	@Column(name="NomPrenomEnfant")
	private String nomprenomenfant;
	@Column(name="Age")
	private String age;
	@Column(name="Classe")
	private String classe;
	@Column(name="Photo")
	private String photo;
	@Column(name="NomPrenomParent")
	private String nomprenomparent;
	@Column(name="NumTel")
	private String numtel;
	@Column(name="MailParent")
	private String mail;
	@JsonIgnore
	@Column(name = "qrCodeImage")
	private String qrCodeImageEnfant;
	
	@ManyToOne
	//@JoinTable(name = "enfant_Jardin",joinColumns = @JoinColumn(name = "idenfant_enfant"),inverseJoinColumns = @JoinColumn(name = "idjardin_jardin"))
	Jardin Jardin;
	
	public Enfant() {
		super();
	}
    
	




	public Enfant(String nomprenomenfant, String age, String classe, String photo) {
		super();
		this.nomprenomenfant = nomprenomenfant;
		this.age = age;
		this.classe = classe;
		this.photo = photo;
	}





	public Enfant(String nomprenomenfant, String age, String classe, String photo, String nomprenomparent,
			String numtel, String mail, String qrCodeImageEnfant, tn.esprit.spring.entity.Jardin jardin) {
		super();
		this.nomprenomenfant = nomprenomenfant;
		this.age = age;
		this.classe = classe;
		this.photo = photo;
		this.nomprenomparent = nomprenomparent;
		this.numtel = numtel;
		this.mail = mail;
		this.qrCodeImageEnfant = qrCodeImageEnfant;
		Jardin = jardin;
	}






	public Enfant(Long idenfant, String nomprenomenfant, String age, String classe, String photo,
			String nomprenomparent, String numtel, String mail, tn.esprit.spring.entity.Jardin jardin) {
		super();
		this.idenfant = idenfant;
		this.nomprenomenfant = nomprenomenfant;
		this.age = age;
		this.classe = classe;
		this.photo = photo;
		this.nomprenomparent = nomprenomparent;
		this.numtel = numtel;
		this.mail = mail;
		Jardin = jardin;
	}






	public String getMail() {
		return mail;
	}






	public Enfant(Long idenfant, String nomprenomenfant, String age, String classe, String photo,
			String nomprenomparent, String numtel, String mail, String qrCodeImageEnfant,
			tn.esprit.spring.entity.Jardin jardin) {
		super();
		this.idenfant = idenfant;
		this.nomprenomenfant = nomprenomenfant;
		this.age = age;
		this.classe = classe;
		this.photo = photo;
		this.nomprenomparent = nomprenomparent;
		this.numtel = numtel;
		this.mail = mail;
		this.qrCodeImageEnfant = qrCodeImageEnfant;
		Jardin = jardin;
	}






	public void setMail(String mail) {
		this.mail = mail;
	}






	public Long getIdenfant() {
		return idenfant;
	}
	public void setIdenfant(Long idenfant) {
		this.idenfant = idenfant;
	}

	public String getAge() {
		return age;
	}
	
	public String getNomprenomenfant() {
		return nomprenomenfant;
	}

	public void setNomprenomenfant(String nomprenomenfant) {
		this.nomprenomenfant = nomprenomenfant;
	}

	public String getNomprenomparent() {
		return nomprenomparent;
	}

	public void setNomprenomparent(String nomprenomparent) {
		this.nomprenomparent = nomprenomparent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
		this.numtel = numtel;
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
