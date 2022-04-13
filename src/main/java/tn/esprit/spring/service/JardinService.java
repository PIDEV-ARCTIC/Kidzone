package tn.esprit.spring.service;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.repository.JardinRepository;
//import tn.esprit.spring.service.*;
//import tn.esprit.spring.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;



@Service
public class JardinService  {

	@Autowired
	JardinRepository jardinRepository;
	
	public List <Jardin> GetJardin(){
		return jardinRepository.findAll();
	}
	public Jardin GetJardinbyid(long idJardin){
		return jardinRepository.findById(idJardin).orElseThrow(null);
	
	}
	public Jardin GetJardinbyName(String nomjardin) {
		return jardinRepository.findByNomjardin(nomjardin);
	
	}
	/*public List <JardinEnfant> GetJardinbyname(string nameJardin){
		return jardinEnfantRepository.findBy(example, queryFunction)(idJardin);
	}*/
	public Jardin addJardinEnfant(Jardin jardinEnfant) {
		return jardinRepository.save(jardinEnfant);
	}
	
	public void deleteJardinEnfant(Long idJardin) {
		jardinRepository.deleteById(idJardin);
		
	}
	public Jardin UpdateJardin(Jardin jardinEnfant){
		Jardin existingJardin = jardinRepository.findById(jardinEnfant.getIdjardin()).orElse(null);
		existingJardin.setDescription(jardinEnfant.getDescription());
		existingJardin.setEmailjardin(jardinEnfant.getEmailjardin());
		existingJardin.setAdressejardin(jardinEnfant.getAdressejardin());
		existingJardin.setLogo(jardinEnfant.getLogo());
		existingJardin.setNomjardin(jardinEnfant.getNomjardin());
		existingJardin.setNumtel(jardinEnfant.getNumtel());
		existingJardin.setTarif(jardinEnfant.getTarif());
		return jardinRepository.save(jardinEnfant);
	}
	
	
}