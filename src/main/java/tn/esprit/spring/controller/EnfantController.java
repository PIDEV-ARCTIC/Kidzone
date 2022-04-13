package tn.esprit.spring.controller;

import java.util.List;

//import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Enfant;
//import tn.esprit.spring.repository.EnfantRepository;
import tn.esprit.spring.service.EnfantService;
//import tn.esprit.spring.service.exception.*;

@RestController  
@RequestMapping("/Enfant")
public class EnfantController {
     
	@Autowired
	private EnfantService EnfantService;
	
	@GetMapping("/EnfantAffich")
	public List<Enfant> afficherEnfant(){
		return EnfantService.GetEnfant();
	}
	@GetMapping("/EnfantAffichid/{idenfant}")
	public Enfant FindEnfantById(@PathVariable long idenfant){
		return EnfantService.GetEnfantbyid(idenfant);
	}
	@GetMapping("/EnfantAffichnom/{nomprenomenfant}")
	public Enfant FindEnfantByName(@PathVariable String nomprenomenfant){
		return EnfantService.GetEnfantbyName(nomprenomenfant);
	}
	@PostMapping("/EnfantAjouter")
	public Enfant addEnfant(@RequestBody Enfant Enfant){
		return EnfantService.addEnfant(Enfant);
	}
	@DeleteMapping("/EnfantSupp/{idenfant}")
	public void deleteEnfant(@PathVariable long idenfant) {
		EnfantService.deleteEnfant(idenfant);}
    
	@PutMapping("/EnfantUpp")
	public Enfant UpdateEnfant(@RequestBody Enfant Enfant){
		return EnfantService.UpdateEnfant(Enfant);
	}
}
