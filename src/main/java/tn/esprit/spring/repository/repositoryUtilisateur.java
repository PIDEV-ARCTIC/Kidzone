package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Utilisateur;
@Repository
public interface repositoryUtilisateur extends JpaRepository<Utilisateur, Long> {
	
	  Optional<Utilisateur> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
	  
	  @Query("SELECT ve, Count(v.username) as Nbre FROM Utilisateur v JOIN v.roles ve GROUP BY ve.name")
	  public List<Object[]> getStats();
}
 