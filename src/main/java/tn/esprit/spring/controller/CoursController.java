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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Cours;

import tn.esprit.spring.service.CoursService;


@RestController
@RequestMapping("/Cours")
public class CoursController {
	@Autowired

	CoursService cou ;
	@GetMapping("/affCourss")
	@ResponseBody
	public List<Cours>  getAllCours(){
		//return SER.getAllReclamation();
		List <Cours> list = cou.getallCours();
		return this.cou.getallCours();
	}
	
		@PostMapping("/add-Cours")
	
	public   Cours addCours(@RequestBody Cours c  ){
		return this.cou.ajouterCours(c);
	}
	
	/*
	@PutMapping("/UpdateReclamation/{idreclamation}/{Nom}/{description}/{Typereclamation}")
	@ResponseBody
	public void UpdateReclamation (@PathVariable ("idreclamation") int idreclamation,@PathVariable("Nom") String Nom,@PathVariable ("description") String description,@PathVariable ("typereclamation") TypeReclamation typereclamation)
	{
		ReclamationService.UpdateReclamation(idreclamation, Nom , description, typereclamation);
	}
	
	
	
	
	*/

		@PutMapping("/modifyCours")
		@ResponseBody
		public Cours modifyCours(@RequestBody Cours c) {
			return this.cou.updateCours(c);
		}
		
	@DeleteMapping("/SupprimerCours/{idcours}")
	@ResponseBody
	public void deleteCours(@PathVariable(" idcours") long  idc )
		{
		this.cou.deletCours( idc);
		}

}
