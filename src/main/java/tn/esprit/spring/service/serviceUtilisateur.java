package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.repository.repositoryUtilisateur;

@Service
public class serviceUtilisateur{

	@Autowired
	repositoryUtilisateur ru;

	public Utilisateur add(Utilisateur s) {
		return 	ru.save(s);

	}

	public Utilisateur update(Utilisateur s) {
		ru.save(s);
		return s;
	}

	public List<Utilisateur> getall() {

		return ru.findAll();
	}

	public Utilisateur renderUser(Long id) {
		return ru.findById(id).orElse(null);
	}
	public Utilisateur delete(Long id) {
		ru.deleteById(id);
		return ru.getById(id);
	}
	


}


