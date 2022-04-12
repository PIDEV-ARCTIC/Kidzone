package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Utilisateur;
@Repository
public interface repositoryUtilisateur extends JpaRepository<Utilisateur, Long> {

}
