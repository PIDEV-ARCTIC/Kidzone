package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Absence;

@Repository 
public interface AbsenceRepository extends JpaRepository<Absence, Long> {

	   @Query("SELECT periode FROM Absence group by periode ")
	    public List<String> absenceByPeriode();
 
  
}
