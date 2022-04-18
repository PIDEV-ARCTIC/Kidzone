package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.service.BusService;

@RestController
public class BusController {
	@Autowired
	private BusService busService;
	
	@PostMapping("/AddBus")
	public Bus AddBus(@RequestBody Bus bus){
		return busService.AddBus(bus);
	}
	
	@GetMapping("/GetBus")
	public List<Bus> Getbus(){
		return busService.GetBus();
	}
	
	@GetMapping("/FindBusById/{idbus}")
	public Bus FindBusById(@PathVariable long idbus){
		return busService.FindBus(idbus);
	}

	
	/*@GetMapping("/JardinEnfantAffichnom/{nomjardin}")
	public Jardin FindJardinByName(@PathVariable String nomjardin){
		return jardinService.GetJardinbyName(nomjardin);
	}*/

	
	@DeleteMapping("/DeleteBus/{idbus}")
	public String DeleteBus(@PathVariable long idbus){
		 return busService.DeleteBus(idbus);
	}
	
	@PutMapping("/UpdateBus")
	public Bus UpdateBus(@RequestBody Bus bus){
		return busService.UpdateBus(bus);
	}

}
