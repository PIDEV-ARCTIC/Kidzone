package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Absence;
import tn.esprit.spring.repository.AbsenceRepository;

@Service
public class AbsenceServiceImpl implements AbsenceService {

	@Autowired
	AbsenceRepository absenceRepository;
	
	@Override
	public List<Absence> retrieveAllAbsence() {
		return absenceRepository.findAll();
	}

	@Override
	public Absence addAbsence(Absence a) {
		return absenceRepository.save(a);
	}

	@Override
	public Absence updateAbsence(Absence a) {
		return absenceRepository.save(a);
	}

	@Override
	public Absence retrieveAbsence(Long id) {
		// TODO Auto-generated method stub
		return absenceRepository.findById(id).get();
	}

	@Override
	public void removeAbsence(Long id) {
		absenceRepository.deleteById(id);
		
	}

    @Override
	public List<String> absenceByPeriode() {
	return absenceRepository.absenceByPeriode();
}

//	@Override
	//public Absence adddAbsence(Absence a) {
	//	return absenceRepository.save(a);
	//}

}
