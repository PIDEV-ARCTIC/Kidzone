package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.Entity.Reclamation;
import tn.esprit.spring.Entity.type;


public interface Ireclamation {
	Reclamation ajouterReclamation(Reclamation r );
	
	void deletReclamation(long  idreclamation);
	List<Reclamation>getallReclamation();
	public Reclamation updateReclamation(Reclamation r);
}
