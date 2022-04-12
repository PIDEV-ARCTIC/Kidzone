package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Reglement;
import tn.esprit.spring.repository.ReglementRepository;
import tn.esprit.spring.service.ReglementService;

@RestController
@RequestMapping("/reglement")
public class ReglementRestController {

	@Autowired
   private ReglementService reglementService;
	//ajouter compte
	@PostMapping("/ajouterr")
	public Reglement addReglement(@RequestBody Reglement c) {
		reglementService.addReglement(c);
		return c;
	}
	@DeleteMapping("/supprimr/{id}")
	public void deleteReglement (@PathVariable long id) {
		reglementService.deleteReglement(id);
	}
	
@GetMapping("/Getreglement")
	public List<Reglement> FindReglement(){
		return reglementService.GetReglement();
	}


@GetMapping("/Findreglement/{id}")
public Reglement FindreglementById(@PathVariable long id){
return reglementService.FindReglement(id);
}
@PutMapping("/UpdateReglement")
public Reglement Updatereglement(@RequestBody Reglement r){
	return reglementService.UpdateReglement(r);
}


	/*@PostMapping(value="/modifc")
	public Compte updateCompte(Compte c) {
		compteRepository.save(c);
		return c;
	}
	
	@PostMapping(value="/rechc")
	public Compte findById(long id) {
	
		
		return compteRepository.findById(id).get();
	}*/
	
}
