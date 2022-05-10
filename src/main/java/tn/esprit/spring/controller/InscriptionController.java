package tn.esprit.spring.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.service.BusService;
import tn.esprit.spring.service.EmailInscriptionService;
import tn.esprit.spring.service.EnfantService;
import tn.esprit.spring.service.InscriptionService;
import tn.esprit.spring.service.PDFGeneratorService;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class InscriptionController {
	@Autowired
	private InscriptionService inscriptionService;
	
	@Autowired
	private EnfantService enfantService;
	
	@Autowired
	private BusService busService;
	
	@Autowired
	private EmailInscriptionService emailInscriptionService;
	
	@Autowired
	private  PDFGeneratorService pdfGeneratorService;
	
	@GetMapping("/pdf")
    public void generatePDF(HttpServletResponse response,Inscription inscription) throws Exception {
		response.setContentType("application/pdf");
        this.pdfGeneratorService.export(response,inscription);
	}
	
	@PostMapping("/AddInscription")
	public Inscription AddInscription(@RequestBody Inscription inscription,HttpServletResponse response) throws MessagingException {
		long idenfant= inscription.getEnfant().getIdenfant();
		this.emailInscriptionService.email(inscription,enfantService.FindMailParent(idenfant),"[Validation d'inscription]","Bonjour Mr/Mme "
				+ enfantService.FindNameParent(idenfant) + "\n" + 
				"Vous venez de valider l'inscription de votre enfant " + enfantService.FindNameChild(idenfant) + " " +enfantService.FindSurNameChild(idenfant) + "\n" +"Vous trouverez ci-dessous l'engagement suivi du réglement interne de notre jardin d'enfant." + "\n"+
						"veuillez la signer et la renvoyer sur ce mail." + "\n" 
						+ "Cordialement." );
		return inscriptionService.AddInscription(inscription);
	}
	
	@GetMapping("/GetInscriptions")
	public List<Inscription> Getinscription(){
		return inscriptionService.GetInscriptions();
	}
	
	@GetMapping("/GetInscriptionsCSV")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);
		
		List<Inscription> listInscriptions = inscriptionService.GetInscriptions();

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = {"Id inscription", "Date opération", "Montant", "Type de payement", "Activité"};
		String[] nameMapping = {"idinscription", "dateoperation", "montant", "typepaiement".toString(), "activite".toString()};
		
		csvWriter.writeHeader(csvHeader);
		
		for (Inscription inscription : listInscriptions) {
			csvWriter.write(inscription, nameMapping);
		}
		
		csvWriter.close();
		
	}
	
	@GetMapping("/FindInscriptionById/{idinscri}")
	public Inscription FindInscriptionById(@PathVariable long idinscri){
		return inscriptionService.FindInscription(idinscri);
	}

	@DeleteMapping("/DeleteInscription/{idinscription}")
	public void DeleteInscription (@PathVariable Long idinscription) {
		inscriptionService.DeleteInscription(idinscription);
	}
	
	@PutMapping("/UpdateInscription")
	public Inscription UpdateInscription(@RequestBody Inscription inscription){
		return inscriptionService.UpdateInscription(inscription);
	}
	
	@GetMapping("/FindinscriBybus/{idbus}")
	public List<Inscription> FindInscriByBus(@PathVariable long idbus){
		return inscriptionService.count(idbus);
	}
	
	@GetMapping("/CountInscritsPerBus/{idbus}")
	public int CountInscriByBus(@PathVariable long idbus){
		return inscriptionService.NombreinscriptionsBus(idbus);
	}
	
	
	@GetMapping("/GetYearInscri/{idinscription}")
	public int GetYear(@PathVariable long idinscription){
		return inscriptionService.getYearInscri(idinscription);
	}
	
	@GetMapping("/GetYears")
	public List<Integer> GetYears(){
		return inscriptionService.getListYear();
	}
	
	@GetMapping("/SommeInscri/{year}")
	public int SommeInscri(@PathVariable int year ){
		return inscriptionService.SommeInscri(year);
	}
	
	@GetMapping("/Taux")
	public List<Float> GetTaux(){
		return inscriptionService.getTaux();
	}
	
	@GetMapping("/Montants")
	public List<Float> GetMontants(){
		return inscriptionService.getMontants();
	}
	
	
	@GetMapping("/RapportYear")
	public List<String> GetRapportYear(){
		return inscriptionService.getRapportYear();
	}
	
	
}
