package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Cours;





@Repository
public interface CoursRepository extends CrudRepository<Cours, Long> {
	

	/* @Query("SELECT c FROM Cours c WHERE c. matiere=:matiere AND c.Description=:Description")
	    Cours getcoursrBymatiereAnddespcription(String matière, String description);
	   
	*/
	@Query("SELECT c FROM Cours c WHERE "
			+ "c.matiere LIKE %?1%"
			+ "OR c.Description LIKE %?1%"
			)
	public List<Cours> search(String keyword);
	
	 
	
	 
	 
	 
	 
	 
	 
	}
