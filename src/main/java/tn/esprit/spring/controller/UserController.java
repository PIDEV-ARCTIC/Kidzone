package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Reclamation;
import tn.esprit.spring.entity.Utilisateur;
import tn.esprit.spring.service.ReclamationService;
import tn.esprit.spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired

	 UserService SER ;

	
		@PostMapping("/add-user")
	
	public  Utilisateur addRUtilisateur(@RequestBody  Utilisateur r  ){
		return this.SER.ajouterUtilisateur(r);
	}

}
