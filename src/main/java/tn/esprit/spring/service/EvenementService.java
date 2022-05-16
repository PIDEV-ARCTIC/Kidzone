package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Evenement;


public interface EvenementService {
	
	List<Evenement> retrieveAllEvenements();
	Evenement addEvenement(Evenement e);
	Evenement updateEvenement(Evenement e);
	Evenement retrieveEvenement(Long id);	
	void removeEvenement(Long id);
	List<String> getAscEvent();
	List<String> getDesevent();
	List<Evenement> findByDescription(String desc);
	List<String> findbytype();
	List<String> findbytypenumber();

	

}
