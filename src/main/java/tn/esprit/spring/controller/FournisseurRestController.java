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

import tn.esprit.spring.Entity.Fournisseur;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.service.FournisseurService;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurRestController {

	@Autowired
   private FournisseurService fournisseurService;
	//ajouter compte
	@PostMapping("/ajouterf")
	public Fournisseur addFournisseur(@RequestBody Fournisseur f) {
		fournisseurService.addFournisseur(f);
		return f;
	}
	@DeleteMapping("/supprimf/{id}")
	public void deleteCompte (@PathVariable long id) {
		fournisseurService.deleteFournisseur(id);
	}
	
@GetMapping("/Getfournisseur")
	public List<Fournisseur> FindFournisseur(){
		return fournisseurService.GetFournisseur();
	}


@GetMapping("/Findfournisseur/{id}")
public Fournisseur FindfournisseurById(@PathVariable long id){
return fournisseurService.FindFournisseur(id);
}
@PutMapping("/UpdateFournisseur")
public Fournisseur Updaterfournisseur(@RequestBody Fournisseur f){
	return fournisseurService.UpdateFournisseur(f);
}
/*@GetMapping("/GetByNom/{NomFournisseur}")
public Fournisseur FindJardinByName(@PathVariable String NomFournisseur){
	return fournisseurService.GetFournByName(NomFournisseur);
}*/
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
