package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Consultation;

@Repository
public interface repositoryConsultation extends JpaRepository<Consultation, Long>{

}
