package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.EnfantRepository;

@Service
public class EnfantService {
	
	@Autowired
	EnfantRepository enfantRepository;
	
	public String FindMailParent(long idenfant){
		 return enfantRepository.findById(idenfant).get().getEmailparent();
	}
	
	public String FindNameParent(long idenfant){
		 return enfantRepository.findById(idenfant).get().getNomparent();
	}
	
	public String FindNameChild(long idenfant){
		 return enfantRepository.findById(idenfant).get().getNomenfant();
	}
	public String FindSurNameChild(long idenfant){
		 return enfantRepository.findById(idenfant).get().getPrenomenfant();
	}

}
