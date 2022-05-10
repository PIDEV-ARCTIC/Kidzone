package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.repository.InscriptionRepository;

@Service
public class InscriptionService {
	
	@Autowired
	private InscriptionRepository inscriptionRepository;
	
	
	
	public Inscription AddInscription(Inscription inscription){
		return inscriptionRepository.save(inscription);
	}
	
	public List <Inscription> GetInscriptions(){
		return inscriptionRepository.findAll();
	}
	
	public Inscription FindInscription(long id){
		return inscriptionRepository.findById(id).get();
	}
	
	/*public Jardin GetJardinbyName(String nomjardin) {
		return jardinRepository.findByNomjardin(nomjardin);
	
	}*/
	
	/*public void DeleteInscription(long idinscri){
		 inscriptionRepository.deleteById(idinscri);
		//return "  Inscription numéro " + idinscri + " est supprimé ";
	}*/
	
	public void DeleteInscription(long idinscri) {
		// TODO Auto-generated method stub
		inscriptionRepository.deleteById(idinscri);
	}
	
	public Inscription UpdateInscription(Inscription inscription){
		Inscription existingInscription = inscriptionRepository.findById(inscription.getIdinscription()).orElse(null);
		existingInscription.setDescription(inscription.getDescription());
		existingInscription.setDateoperation(inscription.getDateoperation());
		existingInscription.setTypepaiement(inscription.getTypepaiement());
		existingInscription.setActivite(inscription.getActivite());
		existingInscription.setMontant(inscription.getMontant());
		return inscriptionRepository.save(inscription);
	}
	
	/*	public List <Inscription> count (long idbus){
		
		List<Inscription> inscriptions = GetInscriptions();
		List<Inscription> inscriptionBus = new ArrayList<>();
		
		 for (Inscription inscri : inscriptions) {
		        if (inscri.getBus().getIdbus()==idbus) {
		            inscriptionBus.add(inscri);
		        }
		 }
		        return inscriptionBus;
	}
	
		public int NombreinscriptionsBus(long idbus){
			 int nbinscrits=0;
			 List<Inscription> inscriptions = GetInscriptions();
			 for (Inscription inscri : inscriptions) {
			        if (inscri.getBus().getIdbus()==idbus) {
			        	nbinscrits++;
			        }
			 }
			    
				return nbinscrits;
				
			}
		
		public int NombreActivites(){
			 int nbactivite=0;
			 List<Inscription> inscriptions = GetInscriptions();
			 for (Inscription inscri : inscriptions) {
			        if (inscri.getActivite().toString() == "true") {
			        	nbactivite++;
			        }
			 }
			    
				return nbactivite;
				
			}*/
		
	public List<Inscription> a(Long idjardin){

		List<Inscription> lista = new ArrayList<>();
		for(Inscription i1 : lista){
			if(i1.getEnfant().getIdenfant() == idjardin){
			//	System.out.print(i1.getEnfant().getJardin().getIdjardin());
		    lista.add(i1);
		    }}
		return lista;
	}
}