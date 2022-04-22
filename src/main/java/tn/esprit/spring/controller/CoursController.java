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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Cours;

import tn.esprit.spring.service.CoursService;


@RestController
@RequestMapping("/Cours")
public class CoursController {
	@Autowired

	CoursService cou ;
	@GetMapping("/affCourss")
	@ResponseBody
	public List<Cours>  getAllCours(){
		//return SER.getAllReclamation();
		List <Cours> list = cou.getallCours();
		return this.cou.getallCours();
	}
	
		@PostMapping("/add-Cours")
	
	public   Cours addCours(@RequestBody Cours c  ){
		return this.cou.ajouterCours(c);
	}
		
		
	
		@GetMapping(value = "/search/{keyword}")
	    public List<Cours> dynamicSearch(@PathVariable String keyword){
			return cou.search(keyword);
	   	 
	    }
		
		
		
		
		
		
	

		@PutMapping("/modifyCours")
		@ResponseBody
		public Cours modifyCours(@RequestBody Cours c) {
			return this.cou.updateCours(c);
		}
		
	@DeleteMapping("/SupprimerCours/{idcours}")
	@ResponseBody
	public void deleteCours(@PathVariable(" idcours") long  idcours )
		{
		this.cou.deletCours( idcours);
		}

	
	/*
	
	@PostMapping("/uploadfile")
	public ResponseEntity<FileUploadResponse> uploadFile(
			@RequestParam("file") MultipartFile multipartFile )
					throws IOException
	{
			String fileName= StringUtils.cleanPath(multipartFile.getOriginalFilename());
			long size = multipartFile.getSize();
			String fileCode =serviceEmployee.saveFile(fileName,multipartFile);
			FileUploadResponse response  = new FileUploadResponse();
			response.setFileName(fileName);
			response.setSize(size);
			response.setDownloadUri("/downloadfile/" + fileCode );
			return new ResponseEntity<>(response , HttpStatus.OK);
	}




		@GetMapping("/downloadfile/{filecode}")
		public ResponseEntity<?> downloadFile(@PathVariable ("filecode") String filecode)
		{
			Resource resource = null;
			
			try {
				 resource = serviceEmployee.getFile(filecode);
			} catch (IOException e) {
	return ResponseEntity.internalServerError().build();

			}
			if( resource == null)
			{
				return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
			}
			String contentType="application/octet-stream";
			String headerValue="attachment; filename=\"" + resource.getFilename() + "\"";
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION , headerValue)
					.body(resource);
		}
		
*/
	}


