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

import tn.esprit.spring.Entity.Utilisateur;
import tn.esprit.spring.services.serviceUtilisateur;

@RestController
@RequestMapping("/api/utilisateur")
public class controllerUtilisateur {
	@Autowired
	serviceUtilisateur serviceUtilisateur;
	@PostMapping
	private Utilisateur addUtilisateur(@RequestBody Utilisateur s)
	{
		return serviceUtilisateur.add(s);
	}
	@GetMapping("{id}")
	private Utilisateur getUtilisateurById(@PathVariable Long id)
	{
		return serviceUtilisateur.getByid(id);
	}
	@GetMapping
	private List<Utilisateur> getAllUtilisateur()
	{
		return serviceUtilisateur.getall();
	}
	@DeleteMapping("{id}")
	private void deleteUtilisateur(@PathVariable Long id)
	{
		serviceUtilisateur.delete(id);
	}
	@PutMapping("{id}")
	private Utilisateur updateUtilisateur(@RequestBody Utilisateur s,@PathVariable Long id)
	{
		return serviceUtilisateur.update(s, id);
	}
}
