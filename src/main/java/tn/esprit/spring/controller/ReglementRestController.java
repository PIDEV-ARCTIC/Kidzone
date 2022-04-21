package tn.esprit.spring.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

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
import tn.esprit.spring.Entity.SmsRequest;
import tn.esprit.spring.service.SmsService;
import tn.esprit.spring.repository.ReglementRepository;
import tn.esprit.spring.service.EmailSenderService;
import tn.esprit.spring.service.FournisseurService;
import tn.esprit.spring.service.PdfGeneratorService;
import tn.esprit.spring.service.ReglementService;

@RestController
@RequestMapping("/reglement")
public class ReglementRestController {

	@Autowired
	private EmailSenderService senderService;
	@Autowired
   private ReglementService reglementService;
	@Autowired
	   private PdfGeneratorService pdfservice;
	@Autowired
	   private FournisseurService fournisseurService;
	
	@Autowired
	 private  SmsService smsService;

	//ajouter compte
	    @Autowired
	    public void  SmsController(SmsService smsService) {
	        this.smsService = smsService;
	    }

	    @PostMapping("sms")
	  //  @Scheduled(cron = "*/10 * * * * *")
	    public void sendSms( @RequestBody SmsRequest smsRequest) {
	    	smsService.sendSms(smsRequest);
	    }

	@PostMapping("/ajouterr")
	public Reglement addReglement(@RequestBody Reglement c,HttpServletResponse response) throws IOException  {
		Properties props = new Properties();
		props.put("mail.smtp.ssl.enable", "true");
		
		reglementService.addReglement(c);
		long id= c.getFournisseurs().getIdfournisseur();
		System.out.print(id);
		//if(c.getFournisseurs()!= null){
			this.senderService.sendEmail(FindfournisseurmailById(id),"payment slip","you have paid "+c.getMontant());
		//	}
			/*else if(c.getFournisseurs()!=null){
				this.senderService.sendEmail(reglementService.FindMailF(c.getIdreglement()),"payment slip","i have paid u "+c.getMontant());

			}
			else 
			senderService.sendEmail(fournisseurService.(c.getIdreglement()),"payment slip","i have paid your salary "+c.getMontant());*/
		
				response.setContentType("application/pdf");
			      //  DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
			        //String currentDateTime = dateFormatter.format(new get());

			       // String headerKey = "Content-Disposition";
			       // String headerValue = "attachment; filename=pdf_" +  ".pdf";
			       // response.setHeader(headerKey, headerValue);

			        this.pdfservice.export(response,c);
		      return c;
	}
	/*@GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response,Reglement r) throws IOException {
		response.setContentType("application/pdf");
      //  DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        //String currentDateTime = dateFormatter.format(new get());

       // String headerKey = "Content-Disposition";
       // String headerValue = "attachment; filename=pdf_" +  ".pdf";
       // response.setHeader(headerKey, headerValue);

        this.pdfservice.export(response,r);
	}*/
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
@GetMapping("/Findfournisseurmail/{id}")
public String FindfournisseurmailById(@PathVariable long id){

return fournisseurService.FindMailF(id);

}
}
