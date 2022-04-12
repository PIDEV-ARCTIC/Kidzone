package tn.esprit.spring.service;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Fournisseur;
import tn.esprit.spring.repository.FournisseurRepository;
import tn.esprit.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class FournisseurService  {

	@Autowired
	FournisseurRepository fournisseurRepository;
	
	public Fournisseur addFournisseur(Fournisseur f) {
		return fournisseurRepository.save(f);
	}
	public void deleteFournisseur(long id) {
		// TODO Auto-generated method stub
		fournisseurRepository.deleteById(id);
		

		
	}
	public Fournisseur updateFournisseur(Fournisseur f) {
		// TODO Auto-generated method stub
		return fournisseurRepository.save(f);
	}
	public List <Fournisseur> GetFournisseur(){
		return fournisseurRepository.findAll();
	}
	public Fournisseur FindFournisseur(long id){
		return fournisseurRepository.findById(id).get();
	}
	public Fournisseur UpdateFournisseur(Fournisseur f){
		Fournisseur existingFournisseu = fournisseurRepository.findById(f.getIdfournisseur()).orElse(null);
		existingFournisseu.setDomaine(f.getDomaine());existingFournisseu.setMailfournisseur(f.getMailfournisseur());
		existingFournisseu.setNomfournisseur(f.getNomfournisseur());existingFournisseu.setPrenomfournisseur(f.getPrenomfournisseur());
		existingFournisseu.setTelfournissuer(f.getTelfournissuer());
		return fournisseurRepository.save(f);
	}
	/*public Fournisseur GetFournByName(String NomFournisseur) {
		return fournisseurRepository.findByNomFourn(NomFournisseur);
	
	}*/
	
	
	

}
