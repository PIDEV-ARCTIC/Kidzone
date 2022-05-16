package tn.esprit.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.http.MediaType;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.exception.EnfantNotFoundException;
import tn.esprit.spring.service.EmailSenderService;
import tn.esprit.spring.service.EnfantService;

@CrossOrigin(origins = "*")
@RestController  
@RequestMapping("/Enfant")
public class EnfantController {
     
	@Autowired
	private EnfantService EnfantService;
	@Autowired
	private EmailSenderService senderService;
	private static String Path_Directory = "C:\\Users\\Store Phone\\Desktop\\Project-KidZone-farah\\imgenfant\\";
	private static String UPLOAD_DIR = "uploads";
	//Generate QRCode
	@GetMapping("/genrateAndDownloadQRCode/{idenfant}")
	@ResponseBody
	public void genrateAndDownloadQRCode(@PathVariable("idenfant") Long idenfant, HttpServletResponse resp,@RequestBody Enfant enfant) throws Exception{
		
		resp.setContentType("image/png");
		
		OutputStream outputStream = resp.getOutputStream();
		System.out.println(outputStream);
		outputStream.write(EnfantService.genrateAndDownloadQRCode(EnfantService.GetEnfantbyID(idenfant), 200, 200, "./src/main/webapp/QRCodeGenerator/QRCode"+idenfant+".png"));
		outputStream.flush();
		outputStream.close();
		
	}
	
	@GetMapping("/EnfantAffich")
	public List<Enfant> afficherEnfant(){
		return EnfantService.GetEnfant();
	}
	@GetMapping("/EnfantAffichid/{idenfant}")
	public Enfant FindEnfantById(@PathVariable long idenfant){
		return EnfantService.GetEnfantbyID(idenfant);
	}
	/*@GetMapping("/EnfantAffichnom/{nomprenomenfant}")
	public Enfant FindEnfantByName(@PathVariable String nomprenomenfant){
		return EnfantService.GetEnfantbyName(nomprenomenfant);
	}*/
	
	/*
	@PostMapping("/EnfantAjouter")
	@ResponseBody
	public Enfant addEnfant(@RequestBody Enfant Enfant,
			HttpServletRequest request,
			HttpServletRequest request2
			) throws Exception{
		/*String fileName_image_product = file_image_product.getOriginalFilename();
		String path_product = request2.getServletContext().getRealPath("") + UPLOAD_DIR + File.separator + fileName_image_product;
		saveFile(file_image_product.getInputStream(), path_product);
		Enfant.setPhoto(fileName_image_product);*/
	/*	String imageQRCodeName = "QRCode"+Enfant.getNomenfant()+".png";
		EnfantService.genrateAndDownloadQRCode2(Enfant.getNomenfant(), 200, 200, "./src/main/webapp/QRCodeGenerator/"+imageQRCodeName);
		return EnfantService.ajouterEnfant(Enfant.getNomenfant(),Enfant.getPrenomenfant(),Enfant.getAdresseEnfant(),Enfant.getAge(),Enfant.getClasse(),Enfant.getMail(),Enfant.getNomprenomparent(),Enfant.getNumtel(),Enfant.getPhoto(), imageQRCodeName,Enfant.getGender(),Enfant.getJardin());
	}*/
	private void saveFile(InputStream inputStream, String path){
		try{
			OutputStream outputStream = new FileOutputStream(new File(path));
			int read = 0;
			byte [] bytes = new byte[1024];
			while((read = inputStream.read(bytes)) != 1){
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
			outputStream.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		@PostMapping("/addEnfant/{idjardin}")
		@ResponseBody
		public Enfant addProduit(@RequestBody Enfant Enfant,
				HttpServletRequest request,
				HttpServletRequest request2,@PathVariable("idjardin") long idjardin) throws Exception
		{		
			String imageQRCodeName = "QRCode"+Enfant.getNomenfant()+".png";
		EnfantService.genrateAndDownloadQRCode2(Enfant.getNomenfant(), 200, 200, "./src/main/webapp/QRCodeGenerator/"+imageQRCodeName);
		 this.senderService.sendEmail("farah.benmahmoud@esprit.tn","Incription","welcome"+Enfant.getJardin()+"Veillezz Inscrire votre enfant"+Enfant.getNomenfant()+Enfant.getPrenomenfant());;
		Enfant Enfant1 = EnfantService.ajouterEnfant(Enfant.getNomenfant(),
				Enfant.getPrenomenfant()
				,Enfant.getAdresseEnfant(),
				Enfant.getAge(),
				Enfant.getClasse(),
                Enfant.getPhoto(),
                Enfant.getNomprenomparent(),
                Enfant.getNumtel(),Enfant.getGender(),
				Enfant.getMail(),
				imageQRCodeName,
				idjardin);
	    return Enfant1;
		}
	@DeleteMapping("/EnfantSupp/{idenfant}")
	public void deleteEnfant(@PathVariable long idenfant) {
		EnfantService.deleteEnfant(idenfant);}
    
	@PutMapping("/EnfantUpp")
	public Enfant UpdateEnfant(@RequestBody Enfant Enfant){
		return EnfantService.UpdateEnfant(Enfant);
	}
	
	@PostMapping("/addphoto")
	@ResponseBody
	public 	Enfant a(@RequestParam("photo") MultipartFile file_image_product,
			HttpServletRequest request,
			HttpServletRequest request2) throws Exception{
		
		String fileName_image_product = file_image_product.getOriginalFilename();
		String path_product = request2.getServletContext().getRealPath("") + UPLOAD_DIR + File.separator + fileName_image_product;
		saveFile(file_image_product.getInputStream(), path_product);
		return EnfantService.ajouterphoto(fileName_image_product);
}
	
}
