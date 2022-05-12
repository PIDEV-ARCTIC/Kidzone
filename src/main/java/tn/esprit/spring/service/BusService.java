package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.repository.BusRepository;
import tn.esprit.spring.repository.InscriptionRepository;

import tn.esprit.spring.service.InscriptionService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@Service
public class BusService {
	
	@Autowired
	private BusRepository busRepository;
	
	@Autowired
	private InscriptionService inscriptionService;
	
	Enfant enfant;
	
	Inscription inscription;
	
	
	public Bus AddBus(Bus bus){
		return busRepository.save(bus);
	}
	
	public List <Bus> GetBus(){
		return busRepository.findAll();
	}
	
	public Bus FindBus(long idbus){
		return busRepository.findById(idbus).get();
	}
	
	
	public void DeleteBus(long idbus){
		
		
		
		//List<Bus> Lbus = this.GetBus();
		List<Inscription> Linscriptions = inscriptionService.GetInscriptions();
		
		for(Inscription inscri : Linscriptions) {
			if (inscri.getBus().getIdbus()==idbus){
				inscri.setBus(null);
			}
	    }
		busRepository.deleteById(idbus);
		//busRepository.getById(idbus);
		
		/*for(Bus bus : Lbus) {
			if (bus.getInscriptions()!=null && bus.getIdbus()==idbus){
				bus.setInscriptions(null);
			}
	    }*/
		
		
		//return " Bus numéro  " + idbus + " est supprimé ";
	}
	
	/*public void DeleteBus(long idbus) {
	    Session currentSession = sessionFactory.getCurrentSession();

	    // get patient with primary key
	    Bus bus = currentSession.get(Bus.class, idbus);  
	    Set<Inscription> inscriptions = bus.getInscriptions();*/

	    //set patient id null
	   /* for(Inscription inscri : inscriptions) {
	        inscri.setBus(null);
	    }*/

	  /*  //delete the patient
	    currentSession.remove(bus);
	}*/
	
	
	
	public Bus UpdateBus(Bus bus){
		Bus existingBus =busRepository.findById(bus.getIdbus()).orElse(null);
		existingBus.setHeuredepart(bus.getHeuredepart());
		existingBus.setDestination(bus.getDestination());
		existingBus.setNbrplaces(bus.getNbrplaces());
		existingBus.setNomChauffeur(bus.getNomChauffeur());
		existingBus.setPrenomChauffeur(bus.getPrenomChauffeur());
		existingBus.setPhotoChauffeur(bus.getPhotoChauffeur());
		return busRepository.save(bus);
	}
	
	public List <Enfant> GetEnfantsBus(Long idbus){
		
		List<Inscription> inscriptions = inscriptionService.GetInscriptions();
		List<Enfant> enfantBus = new ArrayList<>();
		
		
		 for (Inscription inscri : inscriptions) {
		        if (inscri.getBus().getIdbus()==idbus) {
		        	
		        	enfantBus.add(inscri.getEnfant());
		        }
		        
		 }
		        return enfantBus;
		
	}	 
		
	

}
