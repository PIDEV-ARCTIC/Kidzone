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

import tn.esprit.spring.Entity.Reclamation;
import tn.esprit.spring.service.*;

@RestController
@RequestMapping("/rec")
public class ReclamationController {
	@Autowired

	 ReclamationService SER ;
	
	@GetMapping("/Reclamations")
	@ResponseBody
	public List<Reclamation>  getAllReclamations(){
		//return SER.getAllReclamation();
		List <Reclamation> list = SER.getallReclamation();
		return this.SER.getallReclamation();
	}
		@PostMapping("/add-Reclamation")
	
	public   Reclamation addReclamation(@RequestBody  Reclamation r  ){
		return this.SER.ajouterReclamation(r);
	}
	
	/*
	@PutMapping("/UpdateReclamation/{idreclamation}/{Nom}/{description}/{Typereclamation}")
	@ResponseBody
	public void UpdateReclamation (@PathVariable ("idreclamation") int idreclamation,@PathVariable("Nom") String Nom,@PathVariable ("description") String description,@PathVariable ("typereclamation") TypeReclamation typereclamation)
	{
		ReclamationService.UpdateReclamation(idreclamation, Nom , description, typereclamation);
	}
	
	
	
	
	*/

		@PutMapping("/modifyReclamation")
		@ResponseBody
		public Reclamation modifyDepartement(@RequestBody Reclamation r) {
			return this.SER.updateReclamation(r);
		}
		
	@DeleteMapping("/SupprimerReclamation/{idreclamation}")
	@ResponseBody
	public void deleteReclamation(@PathVariable("idreclamation") long idrec )
		{
		this.SER.deletReclamation( idrec);
		}
	
}
