package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Utilisateur;
@Repository
public interface UserRepository extends CrudRepository<Utilisateur, Long> {

}
