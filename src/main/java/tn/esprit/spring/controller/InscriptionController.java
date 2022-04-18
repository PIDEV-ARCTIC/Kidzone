package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.service.InscriptionService;

@RestController
public class InscriptionController {
	@Autowired
	private InscriptionService inscriptionService;
	
	@PostMapping("/AddInscription")
	public Inscription AddInscription(@RequestBody Inscription inscription){
		return inscriptionService.AddInscription(inscription);
	}
	
	@GetMapping("/GetInscriptions")
	public List<Inscription> Getinscription(){
		return inscriptionService.GetInscriptions();
	}
	
	@GetMapping("/FindInscriptionById/{idinscri}")
	public Inscription FindInscriptionById(@PathVariable long idinscri){
		return inscriptionService.FindInscription(idinscri);
	}

	@DeleteMapping("/DeleteInscription/{idinscription}")
	public void DeleteInscription (@PathVariable Long idinscription) {
		inscriptionService.DeleteInscription(idinscription);
	}
	/*@GetMapping("/FindInscriptionByName/{nomedecin}")
	public Inscription FindMedecinById(@PathVariable String nommedecin){
		return inscriptionService.FindInscriptionByName(nommedecin);
	}*/

	
	/*@DeleteMapping("/DeleteInscription/{idinscri}")
	public void DeleteInscription(@PathVariable long idinscri){
		  inscriptionService.DeleteInscription(idinscri);
	}*/
	
	@PutMapping("/UpdateInscription")
	public Inscription UpdateInscription(@RequestBody Inscription inscription){
		return inscriptionService.UpdateInscription(inscription);
	}

}
