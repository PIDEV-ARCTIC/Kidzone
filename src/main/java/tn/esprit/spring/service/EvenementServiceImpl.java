package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Evenement;
import tn.esprit.spring.repository.EvenementRepository;

@Service
public class EvenementServiceImpl implements EvenementService {
	
	@Autowired
	EvenementRepository evenementRepository;

	@Override
	public List<Evenement> retrieveAllEvenements() {
		return evenementRepository.findAll();
	}

	@Override
	public Evenement addEvenement(Evenement e) {
		return evenementRepository.save(e);
	}

	@Override
	public Evenement updateEvenement(Evenement e) {
		return evenementRepository.save(e);
	}

	@Override
	public Evenement retrieveEvenement(Long id) {
		return evenementRepository.findById(id).get();
	}

	@Override
	public void removeEvenement(Long id) {
		evenementRepository.deleteById(id);
	}

	@Override
	public List<String> getAscEvent() {
	    return evenementRepository.Ascevent();
	}

	@Override
	public List<String> getDesevent() {
	    return evenementRepository.Desevent();
	}

	@Override
	public List<Evenement> findByDescription(String desc) {
		// TODO Auto-generated method stub
		return evenementRepository.findByDescription(desc.toUpperCase());
	}

	@Override
	public List<String> findbytype() {
		// TODO Auto-generated method stub
		return evenementRepository.findbytype();
	}

	@Override
	public List<String> findbytypenumber() {
		// TODO Auto-generated method stub
		return evenementRepository.findbytypenumber();
	}
	
	
}
