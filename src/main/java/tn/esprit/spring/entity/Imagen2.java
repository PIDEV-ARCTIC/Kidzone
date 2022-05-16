package tn.esprit.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;



@Entity
public class Imagen2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imagenUrl;
    private String imagenId;

    @OneToOne
    @JsonIgnore
    private Enfant enfant;

	public Imagen2() {
		super();
	}

	public Imagen2(int id, String name, String imagenUrl, String imagenId, Evenement evenement) {
		super();
		this.id = id;
		this.name = name;
		this.imagenUrl = imagenUrl;
		this.imagenId = imagenId;
		this.enfant = enfant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public String getImagenId() {
		return imagenId;
	}

	public void setImagenId(String imagenId) {
		this.imagenId = imagenId;
	}

	

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	@Override
	public String toString() {
		return "Imagen [id=" + id + ", name=" + name + ", imagenUrl=" + imagenUrl + ", imagenId=" + imagenId
				+ ", enfant=" + enfant + "]";
	}

    
}