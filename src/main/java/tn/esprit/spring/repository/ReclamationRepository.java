package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Reclamation;
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

Reclamation findByMail(String mail);

@Query("SELECT typereclamation FROM Reclamation group by typereclamation ")
public List<String> findbytype();

@Query("SELECT count (typereclamation) FROM Reclamation group by typereclamation ")
public List<String> findbytypenumber();






}
