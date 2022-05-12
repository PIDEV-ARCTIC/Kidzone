package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

	  @Query("SELECT  idevenement FROM Evenement order by idevenement ASC ")
	    public List<String> Ascevent();

	    @Query("SELECT  idevenement FROM Evenement order by idevenement DESC ")
	    public List<String> Desevent();
	    
	    @Query("SELECT e FROM Evenement e WHERE upper(e.description) like %:description% ")
	    public List<Evenement> findByDescription( @Param("description") String description);
	    
	    @Query("SELECT type FROM Evenement group by type ")
	    public List<String> findbytype();
	    
	    @Query("SELECT count (type) FROM Evenement group by type ")
	    public List<String> findbytypenumber();
}
