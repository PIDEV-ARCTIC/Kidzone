package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Utilisateur;
import tn.esprit.spring.repositories.repositoryUtilisateur;

@Service
public class serviceUtilisateur implements DAOservices<Utilisateur>{

	@Autowired
	repositoryUtilisateur ru;
	@Override
	public Utilisateur add(Utilisateur s) {
		return 		ru.save(s);

	}

	@Override
	public Utilisateur update(Utilisateur s, Long id) {
		Utilisateur utilisateurexist =ru.findById(id).orElseThrow(null);
		utilisateurexist.setLogin(s.getLogin());
		utilisateurexist.setMdp(s.getMdp());
		utilisateurexist.setType(s.getType());
		ru.save(utilisateurexist);
		return utilisateurexist;
	}

	@Override
	public List<Utilisateur> getall() {
		
		return ru.findAll();
	}

	@Override
	public Utilisateur getByid(Long id) {
		Optional<Utilisateur> utilisateur= ru.findById(id);
		return utilisateur.get();
	}

	@Override
	public Utilisateur delete(Long id) {
		ru.deleteById(id);
		return ru.getById(id);
	}

}
