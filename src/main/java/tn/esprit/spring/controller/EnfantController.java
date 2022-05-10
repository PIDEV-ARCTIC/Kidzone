package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tn.esprit.spring.service.EnfantService;

public class EnfantController {
	
	@Autowired
	EnfantService enfantService;
	
	@GetMapping("/Findmailparent/{id}")
	public String FindparentmailById(@PathVariable long idenfant){

	return enfantService.FindMailParent(idenfant);

	}
}
