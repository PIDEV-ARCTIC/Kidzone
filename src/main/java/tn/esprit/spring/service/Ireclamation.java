package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.type;



public interface Ireclamation {
	Reclamation ajouterReclamation(Reclamation r );
	
	void deletReclamation(long  idreclamation);
	List<Reclamation>getallReclamation();
	public Reclamation updateReclamation(Reclamation r);
	//public Reclamation addReclamation(Reclamation r, Long idutilisateur) ;
	Reclamation retrieveReclamation(Long  idreclamation);
	//public String BlockComplaint (long  idreclamation);
	public void forgotpass(String mail) ;
	List<String> findbytype();
	List<String> findbytypenumber();
	public void getQuantiteRestante(long id);
	
	
	
}