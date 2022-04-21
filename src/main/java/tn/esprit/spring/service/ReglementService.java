package tn.esprit.spring.service;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Reglement;
import tn.esprit.spring.repository.ReglementRepository;
import tn.esprit.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class ReglementService  {

	@Autowired
	ReglementRepository reglementRepository;
	
	public Reglement addReglement(Reglement r) {
		return reglementRepository.save(r);
	}
	public void deleteReglement(long id) {
		// TODO Auto-generated method stub
		reglementRepository.deleteById(id);
	}
	public Reglement updateReglement(Reglement r) {
		// TODO Auto-generated method stub 
		return reglementRepository.save(r);
	}
	public List <Reglement> GetReglement(){
		return reglementRepository.findAll();
	}
	public Reglement FindReglement(long id){
		return reglementRepository.findById(id).get();
	}
	/*public String FindMailF(long id){
		 return reglementRepository.findById(id).get().getFournisseurs().getMailfournisseur();
	}
	public String FindMailE(long id){
		 return reglementRepository.findById(id).get();
	}
	public String FindMailENF(long id){
		 return reglementRepository.findById(id).get().getEnfants().getMail();
	}*/
	public Reglement UpdateReglement(Reglement r){
		Reglement existingReglement = reglementRepository.findById(r.getIdreglement()).orElse(null);
		
		return reglementRepository.save(r);
	}
	
	
	
	/*
	*/

}
