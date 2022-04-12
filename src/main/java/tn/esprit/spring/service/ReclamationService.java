package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.Entity.Reclamation;
import tn.esprit.spring.Entity.type;
import tn.esprit.spring.repository.ReclamationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclamationService implements Ireclamation {
	@Autowired
	ReclamationRepository repo;

	@Override
	public Reclamation ajouterReclamation(Reclamation r) {
		 repo.save(r);
		return r;
	}

	

	@Override
	public void deletReclamation(long idreclamation) {
	 repo.deleteById(idreclamation);
		
	}

	@Override
	public List<Reclamation> getallReclamation() {
		
		return   (List<Reclamation>) this.repo.findAll();
		
	}
	@Override
	public Reclamation updateReclamation(Reclamation r) {
		
		this.repo.save(r);
		return r;
	}
	

}
