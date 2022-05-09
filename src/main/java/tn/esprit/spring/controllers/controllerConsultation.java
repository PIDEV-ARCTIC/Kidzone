package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Consultation;
import tn.esprit.spring.services.serviceConsultation;
@RestController
@RequestMapping("/api/consultation")
public class controllerConsultation
{
	@Autowired
	serviceConsultation serviceConsultation;
	@PostMapping
	private Consultation addConsultation(@RequestBody Consultation s)
	{
		return serviceConsultation.add(s);
	}
	@GetMapping("{id}")
	private Consultation getConsultationById(@PathVariable Long id)
	{
		return serviceConsultation.getByid(id);
	}
	@GetMapping
	private List<Consultation> getConsultation()
	{
		return serviceConsultation.getall();

	}
	@DeleteMapping("{id}")
	private void deleteConsultation(@PathVariable Long id)
	{
		serviceConsultation.delete(id);
	}

	@PutMapping("{id}")
	private Consultation updateConsultation(@RequestBody Consultation s,@PathVariable Long id)
	{
		return null; //serviceConsultation.update(s, id);
	}
}
