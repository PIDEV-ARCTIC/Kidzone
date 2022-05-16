package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.repository.ReclamationRepository;
import tn.esprit.spring.repository.UserRepository;


@Service
public class UserService implements Iuser{
	
	@Autowired
	UserRepository repo;
	@Override
	public Utilisateur retrieveUser(Long idUser) {
		return repo.findById(idUser).get();
	}
	
	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur r) {
		 repo.save(r);
			return r;
	}
	
		
	

}
