package tn.esprit.spring.controller;

import java.util.Date;
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

import tn.esprit.spring.dto.Reclamationtaux;
import tn.esprit.spring.entity.Reclamation;
//import tn.esprit.spring.controller.EmailSenderService;
import tn.esprit.spring.service.*;
import java.util.Date;
import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/rec")
@CrossOrigin(origins="http://localhost:4200")
public class ReclamationController {
	@Autowired

	 ReclamationService SER ;
	@Autowired
	EmailSenderServicenour emailSenderService ;
	//------------------------------------------------------------------------------------------------//
	
	@GetMapping("/Reclamations")
	@ResponseBody
	public List<Reclamation>  getAllReclamations(){
		//return SER.getAllReclamation();
		List <Reclamation> list = SER.getallReclamation();
		return this.SER.getallReclamation();
	}
	
	
	
	//------------------------------------------------------------------------------------------------//
	
		@PostMapping("/add-Reclamation")
	
	public   Reclamation addReclamation(@RequestBody  Reclamation r  ){
		return this.SER.ajouterReclamation(r);
	}
	
		//------------------------------------("routrouver une reclamation")------------------------------------------------------------//
	
		@GetMapping("/retrieve-reclamation/{idreclamation}")
		@ResponseBody
		public Reclamation retrieveClient(@PathVariable("idreclamation") Long idreclamation) {
		return SER.retrieveReclamation(idreclamation);
		}
		
		
		//------------------------------------------------------------------------------------------------//

		@PutMapping("/modifyReclamation")
		@ResponseBody
		public Reclamation modifyDepartement(@RequestBody Reclamation r) {
			return this.SER.updateReclamation(r);
		}
		
		
		//------------------------------------------------------------------------------------------------//
		
		
	@DeleteMapping("/SupprimerReclamation/{idreclamation}")
	@ResponseBody
	public void deleteReclamation(@PathVariable("idreclamation") long idrec )
		{
		this.SER.deletReclamation( idrec);
		}
	
	
	
				
				
				
			//----------------------------------------
				/*
				//filtrage gros mots
				 @PutMapping(value = "/BlockComplaint/{idreclamation}")
					@ResponseBody
					public String BlockComplaint(@PathVariable long idreclamation)  {
						 return SER.BlockComplaint(idreclamation);
					}
				
				 */
				
				 @GetMapping("/sendme/{mail}")
					public void forgotpass(@PathVariable("mail") String mail) {
						SER.forgotpass(mail);
					}
				 
				 @GetMapping("/findbytype")
					@ResponseBody
					public List<String> findbytype() {
					    return SER.findbytype();
					}
					@GetMapping("/findbytypenumber")
					@ResponseBody
					public List<String> findbytypenumber() {
					    return SER.findbytypenumber();
					}
					 @PostMapping("/check/{idreclamation}")
						@ResponseBody
						public void getQuantiteRestante(@PathVariable("idreclamation") long idreclamation)
						{
							SER.getQuantiteRestante(idreclamation);
						}
					 
					 @GetMapping("/tauxservice")
						@ResponseBody
						public List<Reclamationtaux> tauxParticipation(){
						 return SER.tauxParticipation();
					 }

				 
				 
				 
}		 

