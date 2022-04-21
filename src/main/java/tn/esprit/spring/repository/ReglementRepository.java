package tn.esprit.spring.repository;

import tn.esprit.spring.Entity.Fournisseur;
import tn.esprit.spring.Entity.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReglementRepository  extends JpaRepository<Reglement, Long> {

}
