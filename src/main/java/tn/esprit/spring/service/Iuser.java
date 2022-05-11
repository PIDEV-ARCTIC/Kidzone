package tn.esprit.spring.service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Utilisateur;

public interface Iuser {
	public Utilisateur retrieveUser(Long idUser);
	Utilisateur ajouterUtilisateur(Utilisateur r );

}
