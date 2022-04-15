package tn.esprit.spring.service;

import tn.esprit.spring.Entity.Reclamation;
import tn.esprit.spring.Entity.Utilisateur;

public interface Iuser {
	public Utilisateur retrieveUser(Long idUser);
	Utilisateur ajouterUtilisateur(Utilisateur r );

}
