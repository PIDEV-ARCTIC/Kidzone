package tn.esprit.spring.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.repository.BusRepository;
import tn.esprit.spring.service.BusService;
import tn.esprit.spring.service.InscriptionService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class BusController {
	
	private String Path_Directory = "C:\\Kidzone\\photosChauffeur";
	
	@Autowired
	private BusService busService;
	
	@Autowired
	BusRepository busRepository;
	
	public static String uploadDirectory=System.getProperty("user.dir")+"src/main/webapp/imagedata";
	
	@PostMapping("/AddBus")
	//@ResponseBody
	public Bus AddBus(@RequestBody Bus bus){
		return busService.AddBus(bus);
		//return "Data added successfully";
	}
	
	@GetMapping("/GetBus")
	public List<Bus> Getbus(){
		return busService.GetBus();
	}
	
	@GetMapping("/FindBusById/{idbus}")
	public Bus FindBusById(@PathVariable long idbus){
		return busService.FindBus(idbus);
	}

	
	@GetMapping(path="/photoChauffeur/{idbus}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") int idbus) throws Exception{
        Bus bus = busService.FindBus(idbus);
        return Files.readAllBytes(Paths.get(Path_Directory+bus.getPhotoChauffeur()));
    }
    @PostMapping(path = "/UploadPhoto/{idbus}")
    public void uploadPhoto(@RequestParam("file") MultipartFile file, @PathVariable("idbus") int idbus) throws Exception{
        Bus bus=busService.FindBus(idbus);
//        System.out.println(p.getNameprod());
//        System.out.println(file.getOriginalFilename());
        bus.setPhotoChauffeur(file.getOriginalFilename());
        Files.write(Paths.get(Path_Directory+bus.getPhotoChauffeur()),file.getBytes());
        busService.AddBus(bus);
    }
	
	@DeleteMapping("/DeleteBus/{idbus}")
	public void DeleteBus(@PathVariable long idbus){
		
		  busService.DeleteBus(idbus);
	}
	
	@PutMapping("/UpdateBus")
	public Bus UpdateBus(@RequestBody Bus bus){
		return busService.UpdateBus(bus);
	}
	
	@GetMapping("/FindEnfantBybus/{idbus}")
	public List<Enfant> FindInscriByBus(@PathVariable long idbus){
		return busService.GetEnfantsBus(idbus);
	}
	
}
