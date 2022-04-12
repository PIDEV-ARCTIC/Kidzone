package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.Entity.Cours;



public interface Icours {
	Cours ajouterCours(Cours c );
	
	void deletCours(long  idcours);
	List<Cours>getallCours();
	public Cours updateCours(Cours c);

}
