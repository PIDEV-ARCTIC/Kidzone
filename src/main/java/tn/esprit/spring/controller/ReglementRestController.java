package tn.esprit.spring.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//import java.io.IOException;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.entity.Reglement;

import tn.esprit.spring.repository.ReglementRepository;
import tn.esprit.spring.service.EmailSenderService;
import tn.esprit.spring.service.FournisseurService;
//import tn.esprit.spring.service.PdfGeneratorService;
import tn.esprit.spring.service.ReglementService;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/reglement")
public class ReglementRestController {

	@Autowired
	private EmailSenderService senderService;
	@Autowired
   private ReglementService reglementService;
	//@Autowired
	 //  private PdfGeneratorService pdfservice;
	@Autowired
	   private FournisseurService fournisseurService;
	
	

	@PostMapping("/ajouterr")
	public Reglement addReglement(@RequestBody Reglement c,HttpServletResponse response) throws MessagingException  {
		Properties props = new Properties();
		props.put("mail.smtp.ssl.enable", "true");
		
		reglementService.addReglement(c);
	
		//if(c.getFournisseurs()!= null){
		this.senderService.email(c,c.getMail(),"[Validation de reglement]","Bonjour Mr/Mme "
				+ c.getIdtier() + "\n" + 
				"Vous venez de payer " + c.getMontant() + " " +"en mode "+c.getMode()+"\n" +"Vous trouverez ci-dessous l'engagement suivi du réglement interne de notre jardin d'enfant." + "\n"+
						"veuillez la signer et la renvoyer sur ce mail." + "\n" 
						+ "Cordialement.");
			
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
	System.out.print(r);
	return reglementService.UpdateReglement(r);
	
}


	
@GetMapping("/Findfournisseurmail/{id}")
public String FindfournisseurmailById(@PathVariable long id){

return fournisseurService.FindMailF(id);

}
@GetMapping("/EtatC")
public List<Reglement> EtatC( ){

//String typef="fournisseur";
return reglementService.EtatDeCaisse();
}

@GetMapping("/EtatCD")
public int EtatCD( ){

//String typef="fournisseur";
return reglementService.EtatDeCaisseDet();
}

@GetMapping("/EtatCDt")
public int EtatCDT( ){

//String typef="fournisseur";
return reglementService.EtatDeCaisseDett();
}
@GetMapping("/EtatCDCH")
public int EtatCDch( ){

//String typef="fournisseur";
return reglementService.EtatDeCaisseChec();
}
@GetMapping("/EtatCDcart")
public int EtatCDcart( ){

//String typef="fournisseur";
return reglementService.EtatDeCaisseDetCart();
}
@GetMapping("/EtatCDEss")
public int EtatCDEss( ){

//String typef="fournisseur";
return reglementService.EtatDeCaisseESS();
}
@GetMapping("/Echf")
public List<Reglement> EchF( ){

return reglementService.Echfourn();
}
@GetMapping("/stat1")
public List<String> Statistique1( ){

return reglementService.Stat1();
}
@GetMapping("/stat2")
public List<Long> Statistique2( ){

return reglementService.Stat2();
}

@GetMapping("/Echc")
public List<Reglement> Echc( ){
return reglementService.Echanf();
}
@GetMapping("/Alert")
public String Alert( ){
return reglementService.Alert();
}
}
