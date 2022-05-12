package tn.esprit.spring.repository;

import tn.esprit.spring.entity.Fournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FournisseurRepository  extends JpaRepository<Fournisseur, Long> {
	 Fournisseur findByNomfournisseur(String  nomfournisseur);
	 
	

}
