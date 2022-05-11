package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		existingInscription.setDateoperation(inscription.getDateoperation());
		existingInscription.setTypepaiement(inscription.getTypepaiement());
		existingInscription.setActivite(inscription.getActivite());
		existingInscription.setMontant(inscription.getMontant());
		return inscriptionRepository.save(inscription);
	}
	
		public List <Inscription> count (long idbus){
		
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
				
			}
		
		
		public int getYearInscri(long idinscription){
			
			List<Inscription> inscriptions = GetInscriptions();
			for (Inscription inscri : inscriptions) {
		        if (inscri.getIdinscription()==idinscription) {
		        	
		        	return  (inscri.getDateoperation().getYear()+1900); 
		        }
		 }
			return 0;
		}
		
		public List <Integer> getListYear(){
			List<Inscription> inscriptions = GetInscriptions();
			List<Integer> years = new ArrayList<>();
			
			for (Inscription inscri : inscriptions) {
				years.add((inscri.getDateoperation().getYear()+1900));			
			}
			Set<Integer> set = new HashSet<>(years);
			years.clear();
			years.addAll(set);    
			return years;
		}
		
		public int SommeInscri(int year){
			List<Inscription> inscriptions = GetInscriptions();
			int nbrinscri=0;
			for (Inscription inscri : inscriptions) {
		        if ((inscri.getDateoperation().getYear()+1900)==year) {
		        	nbrinscri++;
		        }
		 }
			return nbrinscri;
		}
		
		public int SommeMontant(int year){
			List<Inscription> inscriptions = GetInscriptions();
			int Montants=0;
			for (Inscription inscri : inscriptions) {
		        if ((inscri.getDateoperation().getYear()+1900)==year) {
		        	Montants=inscri.getMontant()+Montants;
		        }
		 }
			return Montants;
		}
		
		public List <Float> getMontants(){
			
			List<Integer> years = getListYear();
			List<Float> montants = new ArrayList<>();
			//int[] Taux;
			
			for (int i=1 ; i<years.size();i++){
				int X=(this.SommeMontant(years.get(i))-this.SommeMontant(years.get(i-1)));
				int Y=this.SommeMontant(years.get(i-1));
				
				montants.add((((float)X-(float)Y)/(float)Y)*100);
			}
			return montants;
		}
		
		public List <Float> getTaux(){
			
			List<Integer> years = getListYear();
			List<Float> taux = new ArrayList<>();
			//int[] Taux;
			
			for (int i=1 ; i<years.size();i++){
				int X=this.SommeInscri(years.get(i));//-this.SommeInscri(years.get(i-1)));
				int Y=this.SommeInscri(years.get(i-1));
				
				//taux.add(tau);
				taux.add((((float)X-(float)Y)/(float)Y)*100);
				
			}
			return taux;
		}
		
			public List <String> getRapportYear(){
						
						List<Integer> years = getListYear();
						List<String> rapport = new ArrayList<>();
						//int[] Taux;
						
						for (int i=1 ; i<years.size();i++){
							/*int X=years.get(i)years.get(i-1)));
							int Y=this.SommeInscri(years.get(i-1));
							int tau= (X/Y)*100;*/
							rapport.add(years.get(i).toString() + "/" + years.get(i-1).toString() );
						}
						return rapport;
					}
}
	
	
	
	
	
	
	
	


