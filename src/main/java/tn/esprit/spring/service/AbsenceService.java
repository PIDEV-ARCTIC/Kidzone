package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Absence;

public interface AbsenceService {
	
	List<Absence> retrieveAllAbsence();
	Absence addAbsence(Absence a);
	//Absence adddAbsence(Absence a);
	Absence updateAbsence(Absence a);
	Absence retrieveAbsence(Long id);	
	void removeAbsence(Long id);
   List<String> absenceByPeriode();

}
