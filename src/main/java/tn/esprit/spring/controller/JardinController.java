package tn.esprit.spring.controller;

import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
//import org.springframework.http.MediaType;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
//import org.aspectj.lang.annotation.RequiredTypes;
//import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;

import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Inscription;
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
	private String Path_Directory = "C:\\Users\\Store Phone\\Desktop\\Project-KidZone-farah\\imgjardin\\";
	
	@GetMapping("/JardinEnfantAffich")
	public List<Jardin> afficherJardin(){
		return jardinService.GetJardin();
	}
	@GetMapping("/JardinEnfantAdresse")
	@ResponseBody
	public List<String> findbytypenumber() {
	    return jardinService.findbytypenumber();
	}
	
	@GetMapping("/JardinAffichEnfant/{idjardin}")
	public List<Enfant> afficherJardinEnfant(@PathVariable long idjardin){
		
		return jardinService.bbb(idjardin);
		 
	}
	
	@GetMapping("/JardinEnfantAffichid/{idJardin}")
	public Jardin FindJardinById(@PathVariable long idJardin){
		return jardinService.GetJardinbyid(idJardin);
	}
	@GetMapping("/JardinEnfantAffichnom/{nomjardin}")
	public Jardin FindJardinByName(@PathVariable String nomjardin){
		return jardinService.GetJardinbyName(nomjardin);
	}
	
	//@RequestMapping(method = RequestMethod.POST, path = "/{id}/documents") public DeferredResult<ResponseEntity<?>> uploadDocuments( @PathVariable String id, @RequestParam("file") MultipartFile[] files )
	@PostMapping("/JardinEnfantAjouter")
	public Jardin addJardinEnfant(@RequestBody Jardin jardinEnfant){
		return jardinService.addJardinEnfant(jardinEnfant);
	}
	
	@PostMapping("/uploadPhoto/{idjardin}")
    public void uploadPhoto(@RequestParam("file") MultipartFile file, @PathVariable("idjardin") long idjardin) throws Exception{
		Jardin p=jardinService.GetJardinbyid(idjardin);
//        System.out.println(p.getNameprod());
//        System.out.println(file.getOriginalFilename());
        p.setLogo(file.getOriginalFilename());
        Files.write(Paths.get(Path_Directory+p.getLogo()),file.getBytes());
        jardinService.addJardinEnfant(p);}
	
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
	@GetMapping("/CA/{idjardin}")
	public List<Integer> CA( @PathVariable("idjardin") long idjardin){
		return jardinService.CAJardin(idjardin);
	}
	@GetMapping("/aa/{idjardin}")
	public List<Inscription> a(@PathVariable long idjardin){
		
		return jardinService.a(idjardin);
		 
	}
	/*@GetMapping("/CA2")
	public List<Long> CA2(){
		return jardinService.CA2();
	}*/
	/*@PostMapping(path = "/uploadPhoto/{idjardin}")
    public void uploadPhoto(@RequestParam("file") MultipartFile file, @PathVariable("idjardin") int idjardin) throws Exception{
        Jardin p=jardinService.GetJardinbyid(idJardin);
//        System.out.println(p.getNameprod());
//        System.out.println(file.getOriginalFilename());
        p.setLogo(file.getOriginalFilename());
        Files.write(Paths.get(Path_Directory+p.getImageFileNameProduct()),file.getBytes());
        service.saveProduct(p);}*/
}

