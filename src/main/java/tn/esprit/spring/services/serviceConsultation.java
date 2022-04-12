package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Consultation;
import tn.esprit.spring.repositories.repositoryConsultation;

@Service
public class serviceConsultation implements DAOservices<Consultation>{

	@Autowired
	repositoryConsultation rc;
	@Override
	public Consultation add(Consultation s) {
		return rc.save(s);

	}

	@Override
	public Consultation update(Consultation s, Long id) {
		Consultation consultationExist= rc.findById(id).orElseThrow(null);
		consultationExist.setDateConsultation(s.getDateConsultation());
		consultationExist.setDescription(s.getDescription());
		rc.save(consultationExist);
		return consultationExist;
	}

	@Override
	public List<Consultation> getall() {
		return rc.findAll();
	}

	@Override
	public  Consultation getByid(Long id) {
		Consultation consultation=rc.findById(id).orElseThrow(null);
		return consultation;
	}

	@Override
	public Consultation delete(Long id) {
		rc.deleteById(id);
		return null;
	}

}
