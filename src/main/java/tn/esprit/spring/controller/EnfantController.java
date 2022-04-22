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
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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


@RestController  
@RequestMapping("/Enfant")
public class EnfantController {
     
	@Autowired
	private EnfantService EnfantService;
	
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
	@GetMapping("/EnfantAffichnom/{nomprenomenfant}")
	public Enfant FindEnfantByName(@PathVariable String nomprenomenfant){
		return EnfantService.GetEnfantbyName(nomprenomenfant);
	}
	/*@PostMapping("/EnfantAjouter")
	public Enfant addEnfant(@RequestParam("nomprenomenfant") String nomprenomenfant,
			@RequestParam("age") String age,
			HttpServletRequest request,
			HttpServletRequest request2,
			@RequestParam("classe") String classe,
			@RequestParam("photo") MultipartFile file_image_product,
			@RequestParam("nomprenomparent") String nomprenomparent,
			@RequestParam("numtel") String numtel,
			@RequestParam("mail") String mail,
			@RequestParam("jardin") tn.esprit.spring.entity.Jardin jardin,
			@RequestParam("qrCodeImageEnfant") String qrCodeImageEnfant) throws Exception{
	//	logger.info("walletName {} and currencyName {}", myJsonRequestComingIn.getWalletName(), myJsonRequestComingIn.getCurrencyName());
		String fileName_image_product = file_image_product.getOriginalFilename();
		String path_product = request2.getServletContext().getRealPath("") + UPLOAD_DIR + File.separator + fileName_image_product;
		saveFile(file_image_product.getInputStream(), path_product);
		String imageQRCodeName = "QRCode"+nomprenomenfant+".png";
		EnfantService.genrateAndDownloadQRCode2(nomprenomenfant, 200, 200, "./src/main/webapp/QRCodeGenerator/"+imageQRCodeName);
		return EnfantService.ajouterEnfant(nomprenomenfant, fileName_image_product,age, classe, nomprenomparent, numtel, mail, imageQRCodeName,jardin);
	}*/
	@PostMapping("/EnfantAjouter")
	@ResponseBody
	public Enfant addEnfant(@RequestBody Enfant Enfant,
			HttpServletRequest request,
			HttpServletRequest request2
			) throws Exception{

		String imageQRCodeName = "QRCode"+Enfant.getNomprenomenfant()+".png";
		EnfantService.genrateAndDownloadQRCode2(Enfant.getNomprenomenfant(), 200, 200, "./src/main/webapp/QRCodeGenerator/"+imageQRCodeName);
		return EnfantService.ajouterEnfant(Enfant.getNomprenomenfant(), Enfant.getAge(),Enfant.getClasse(),Enfant.getMail(),Enfant.getNomprenomparent(),Enfant.getNumtel(),Enfant.getPhoto(), imageQRCodeName,Enfant.getJardin());
	}
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
	@DeleteMapping("/EnfantSupp/{idenfant}")
	public void deleteEnfant(@PathVariable long idenfant) {
		EnfantService.deleteEnfant(idenfant);}
    
	@PutMapping("/EnfantUpp")
	public Enfant UpdateEnfant(@RequestBody Enfant Enfant){
		return EnfantService.UpdateEnfant(Enfant);
	}
}
