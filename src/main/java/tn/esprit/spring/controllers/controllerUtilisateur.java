package tn.esprit.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Utilisateur;
import tn.esprit.spring.repositories.repositoryUtilisateur;
import tn.esprit.spring.security.jwt.AuthTokenFilter;
import tn.esprit.spring.security.jwt.JwtUtils;
import tn.esprit.spring.security.services.UserDetailsServiceImpl;
import tn.esprit.spring.services.serviceUtilisateur;

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class controllerUtilisateur {


	@Autowired
	serviceUtilisateur su;

	@Autowired  
	repositoryUtilisateur repo;  
	@Secured({ "ROLE_ADMIN", "ROLE_RESPONSABLE" })
	@GetMapping("/userList")
	private List<Utilisateur> getAllUtilisateur(){
		List <Utilisateur> lst = su.getall();
		return lst;
	} 
	@GetMapping("/stats")
	private List<Object[]> getStats(){
		List<Object[]> lst = repo.getStats();
		return lst;
	}
	@GetMapping("/user/{id}")
	private Utilisateur getUtilisateurById(@PathVariable Long id) {
		return su.renderUser(id);
	}

	@PostMapping("/addUser")
	private Utilisateur addUtilisateur(@RequestBody Utilisateur utililisateur) {
		return su.add(utililisateur);
	}
	@DeleteMapping("/delete/{id}")
	private void deleteUtilisateur(@PathVariable Long id) {
		su.delete(id);
	}

	@PutMapping("/update")
	public ResponseEntity<Utilisateur>  updateUtilisateur(@RequestBody Utilisateur s) {
		Utilisateur updateUtilisateur = su.update(s);
		return new ResponseEntity<>(updateUtilisateur, HttpStatus.OK);
	}
}
