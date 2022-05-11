package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Utilisateur;
@Repository
public interface UserRepository extends CrudRepository<Utilisateur, Long> {

}
