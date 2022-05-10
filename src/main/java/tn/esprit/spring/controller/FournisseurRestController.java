package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
@RestController //permet de convertir des reponse en json ou xml
@RequestMapping("/fournisseur")
public class FournisseurRestController {

	@Autowired
   private FournisseurService fournisseurService;
	//ajouter compte
	@PostMapping("/ajouterf")
	public Fournisseur addFournisseur(@RequestBody/* plusieur paramettre a ajouter*/ Fournisseur f) {
		fournisseurService.addFournisseur(f);
		return f;
	}
	@DeleteMapping("/supprimf/{id}")
	public void deleteFournisseur (@PathVariable long id) {
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
@GetMapping("/Findfournisseurmail/{id}")
public String FindfournisseurmailById(@PathVariable long id){

return fournisseurService.FindMailF(id);

}
@PutMapping("/UpdateFournisseur")
public Fournisseur Updaterfournisseur(@RequestBody Fournisseur f) {
	
	return fournisseurService.UpdateFournisseur(f);
}
@GetMapping("/GetByNom/{NomFournisseur}")
public Fournisseur FindFournisseurByName( @PathVariable String NomFournisseur){
	return fournisseurService.GetFournByName(NomFournisseur);
}
	
	
}