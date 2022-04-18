package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.repository.InscriptionRepository;

@Service
public class InscriptionService {
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	public Inscription AddInscription(Inscription inscription){
		return inscriptionRepository.save(inscription);
	}
	
	public List <Inscription> GetInscriptions(){
		return inscriptionRepository.findAll();
	}
	
	public Inscription FindInscription(long id){
		return inscriptionRepository.findById(id).get();
	}
	
	/*public Jardin GetJardinbyName(String nomjardin) {
		return jardinRepository.findByNomjardin(nomjardin);
	
	}*/
	
	/*public void DeleteInscription(long idinscri){
		 inscriptionRepository.deleteById(idinscri);
		//return "  Inscription numéro " + idinscri + " est supprimé ";
	}*/
	
	public void DeleteInscription(long idinscri) {
		// TODO Auto-generated method stub
		inscriptionRepository.deleteById(idinscri);
	}
	
	public Inscription UpdateInscription(Inscription inscription){
		Inscription existingInscription = inscriptionRepository.findById(inscription.getIdinscription()).orElse(null);
		existingInscription.setDescription(inscription.getDescription());
		existingInscription.setDateoperation(inscription.getDateoperation());
		existingInscription.setTypepaiement(inscription.getTypepaiement());
		existingInscription.setActivite(inscription.getActivite());
		return inscriptionRepository.save(inscription);
	}
	
	

}
