package tn.esprit.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerContact {
	@GetMapping("/contact")
	public String showContactForm()
	{
		return "contact_form";
	}
	

}
