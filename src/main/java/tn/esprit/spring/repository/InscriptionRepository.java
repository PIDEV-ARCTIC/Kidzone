package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Inscription;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription,Long> {

	
	//Inscription findByNomjardin(String nom);
}
