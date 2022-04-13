package tn.esprit.spring.repository;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Enfant;
//import tn.esprit.spring.entity.Jardin;

@Repository
public interface EnfantRepository extends JpaRepository<Enfant, Long>{

	 Enfant findByNomprenomenfant(String nomprenomenfant);
}
