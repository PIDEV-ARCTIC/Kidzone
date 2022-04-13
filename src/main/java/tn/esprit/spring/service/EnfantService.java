package tn.esprit.spring.service;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.repository.EnfantRepository;
//import tn.esprit.spring.service.*;
//import tn.esprit.spring.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;



@Service
public class EnfantService  {

	@Autowired
	EnfantRepository EnfantRepository;
	
	public List <Enfant> GetEnfant(){
		return EnfantRepository.findAll();
	}
	public Enfant GetEnfantbyid(long idenfant){
		return EnfantRepository.findById(idenfant).orElseThrow(null);
	
	}
	public Enfant GetEnfantbyName(String nomprenomenfant) {
		return EnfantRepository.findByNomprenomenfant(nomprenomenfant);
	
	}
	public Enfant addEnfant(Enfant Enfant) {
		return EnfantRepository.save(Enfant);
	}
	
	public void deleteEnfant(Long idenfant) {
		EnfantRepository.deleteById(idenfant);
		
	}
	public Enfant UpdateEnfant(Enfant Enfant){
		Enfant existingEnfant = EnfantRepository.findById(Enfant.getIdenfant()).orElse(null);
		existingEnfant.setAge(Enfant.getAge());
		existingEnfant.setClasse(Enfant.getClasse());
		existingEnfant.setJardin(Enfant.getJardin());
		existingEnfant.setNomprenomenfant(Enfant.getNomprenomenfant());
		existingEnfant.setNomprenomparent(Enfant.getNomprenomparent());
		existingEnfant.setNumtel(Enfant.getNumtel());
		existingEnfant.setPhoto(Enfant.getPhoto());
		return EnfantRepository.save(Enfant);
	}
	
	
}