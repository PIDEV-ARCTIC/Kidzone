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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Absence;
import tn.esprit.spring.entity.Evenement;
import tn.esprit.spring.service.AbsenceService;
import tn.esprit.spring.service.EvenementService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/evenement")
public class EvenementController {
	

	@Autowired
	EvenementService evenementService ;
	
	@GetMapping("/getAll")
	public List<Evenement> getAllEvenements(){
		return evenementService.retrieveAllEvenements();
	}
	
	@GetMapping("/{id}")
	public Evenement getById(@PathVariable Long id){
		return evenementService.retrieveEvenement(id);
	}
	
	@PostMapping("/add")
	public Evenement addEvenement(@RequestBody Evenement e){
		return evenementService.addEvenement(e);
	}
	
	@PutMapping("/update")
	public Evenement updateEvenement(@RequestBody Evenement e){
		return evenementService.updateEvenement(e);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEvenement(@PathVariable Long id){
		evenementService.removeEvenement(id);
	}
	
	@GetMapping("/find/{desc}")
	@ResponseBody
	public List<Evenement> rechercheDesc(@PathVariable String desc ) {
	    return evenementService.findByDescription(desc);
	}
	// http://localhost:8080/evenement/getAscEvent
	@GetMapping(value = "getAscEvent")
	@ResponseBody
	public List<String> getAscEvent() {
	    return evenementService.getAscEvent();
	}

	// http://localhost:8080/evenement/getDesevent
	@GetMapping(value = "getDesevent")
	@ResponseBody
	public List<String> getDesevent() {
	    return evenementService.getDesevent();
	}
	@GetMapping(value = "findbytype")
	@ResponseBody
	public List<String> findbytype() {
	    return evenementService.findbytype();
	}
	@GetMapping(value = "findbytypenumber")
	@ResponseBody
	public List<String> findbytypenumber() {
	    return evenementService.findbytypenumber();
	}
}
