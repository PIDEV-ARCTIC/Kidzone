package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import tn.esprit.spring.Entity.Cours;






public interface CoursRepository extends JpaRepository<Cours, Long> {
	

	/* @Query("SELECT c FROM Cours c WHERE c. matiere=:matiere AND c.Description=:Description")
	    Cours getcoursrBymatiereAnddespcription(String matière, String description);
	   
	*/
	@Query("SELECT c FROM Cours c WHERE "
			+ "c.matiere LIKE %?1%"
			+ "OR c.Description LIKE %?1%"
			)
	public List<Cours> search(String keyword);
	
	 
	
	 
	 
	 
	 
	 
	 
	}
