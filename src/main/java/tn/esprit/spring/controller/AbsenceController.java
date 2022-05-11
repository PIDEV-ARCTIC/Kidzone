package tn.esprit.spring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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
import tn.esprit.spring.service.AbsenceService;
import tn.esprit.spring.service.EmailPdf;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/absence")
public class AbsenceController {
	@Autowired
	EmailPdf emailpdf;

	@Autowired
	AbsenceService absenceService ;
	
	// http://localhost:8081/KidZone/absence/getAll
	@GetMapping("/getAll")
	public List<Absence> getAllAbsences(){
		return absenceService.retrieveAllAbsence();
	}
	// http://localhost:8081/KidZone/absence/1
	@GetMapping("/{id}")
	public Absence getById(@PathVariable Long id){
		return absenceService.retrieveAbsence(id);
	}
	
	
	// http://localhost:8081/KidZone/absence/add
	
	@PostMapping("/add")
	public Absence addAbsence(@RequestBody Absence a){
		return absenceService.addAbsence(a);
		
	}
	
	// http://localhost:8081/KidZone/absence/pdfgenerate
	
		@GetMapping("/pdfgenerate")
		public void  generatePDF(){
			emailpdf.CreatePdf();
			
		}
	
	//@PostMapping("/addd")
	//public Absence adddAbsence(@RequestBody Absence a){
	//	return absenceService.adddAbsence(a);
	//}
	// http://localhost:8081/KidZone/absence/update
		
	@PutMapping("/update")
	public Absence updateAbsence(@RequestBody Absence a){
		return absenceService.updateAbsence(a);
	}
	// http://localhost:8081/KidZone/absence/delete/:id
	
	@DeleteMapping("/delete/{id}")
	public void deleteAbsence(@PathVariable Long id){
		absenceService.removeAbsence(id);
	}
	
	// http://localhost:8081/KidZone/absence/absenceByPeriode
	@GetMapping(value = "absenceByPeriode")
	@ResponseBody
	public List<String> absenceByPeriode() {
	    return absenceService.absenceByPeriode();
	}
	
	// http://localhost:8081/KidZone/absence/findByemployeeperiod
		//@GetMapping("/findByemployeeperiod")
	//	public List<String> findByemployeeperiod(){
		//	return absenceService.findByemployeeperiod();
		//}
}
