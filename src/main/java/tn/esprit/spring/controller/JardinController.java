package tn.esprit.spring.controller;

import java.util.List;

//import org.aspectj.lang.annotation.RequiredTypes;
//import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.service.EmailSenderService;
//import tn.esprit.spring.repository.JardinRepository;
import tn.esprit.spring.service.JardinService;
//import tn.esprit.spring.service.exception.*;
@CrossOrigin(origins = "*")
@RestController  
@RequestMapping("/JardinEnfant")
public class JardinController {
     
	@Autowired
	private JardinService jardinService;
	@Autowired
	private EmailSenderService senderService;
	
	@GetMapping("/JardinEnfantAffich")
	public List<Jardin> afficherJardin(){
		return jardinService.GetJardin();
	}
	@GetMapping("/JardinAffichEnfant/{idjardin}")
	public List<Enfant> afficherJardinEnfant(@PathVariable long idjardin){
		return jardinService.count(idjardin);
	}
	@GetMapping("/JardinEnfantAffichid/{idJardin}")
	public Jardin FindJardinById(@PathVariable long idJardin){
		return jardinService.GetJardinbyid(idJardin);
	}
	@GetMapping("/JardinEnfantAffichnom/{nomjardin}")
	public Jardin FindJardinByName(@PathVariable String nomjardin){
		return jardinService.GetJardinbyName(nomjardin);
	}
	@PostMapping("/JardinEnfantAjouter")
	public Jardin addJardinEnfant(@RequestBody Jardin jardinEnfant){
		return jardinService.addJardinEnfant(jardinEnfant);
	}
	@DeleteMapping("/JardinSupp/{idJardin}")
	public void deleteJardinEnfant(@PathVariable long idJardin) {
		jardinService.deleteJardinEnfant(idJardin);}
    
	@PutMapping("/JardinUpp")
	public Jardin UpdateJardin(@RequestBody Jardin jardinEnfant){
		return jardinService.UpdateJardin(jardinEnfant);
	}
	@PostMapping("/Inscription")
	public void RecJardinEnfant(@RequestBody Jardin jardinEnfant){
	 this.senderService.sendEmail("farah.benmahmoud@esprit.tn","Reclamation2","problemefarah "+"amal");;
	}
}
