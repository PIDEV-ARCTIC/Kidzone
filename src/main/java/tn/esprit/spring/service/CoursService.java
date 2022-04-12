package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Cours;
import tn.esprit.spring.Entity.Reclamation;
import tn.esprit.spring.repository.CoursRepository;
import tn.esprit.spring.repository.ReclamationRepository;
@Service

public class CoursService implements Icours {
	@Autowired
	CoursRepository repo;
	@Override
	public Cours ajouterCours(Cours c) {
		repo.save(c);
		return c;
	}

	@Override
	public void deletCours(long idcours) {
		 repo.deleteById(idcours);
		
	}

	@Override
	public List<Cours> getallCours() {
		return   (List<Cours>) this.repo.findAll();
	}

	@Override
	public Cours updateCours(Cours c) {
		this.repo.save(c);
		return c;
	}

}
