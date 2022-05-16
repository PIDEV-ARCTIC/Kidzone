package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Inscription;

@Repository
public interface JardinRepository extends JpaRepository<Jardin, Long>{

	 Jardin findByNomjardin(String nomjardin);
	 List<Jardin> findByAdressejardin(String adresse);
	 Jardin findByIdjardin(long idjardin);
	//@Query("select sum(j.tarif) from Jardin j where (j.idjardin = (select e.Jardin from Enfant e ,Inscription inscri  where e.idenfant=inscri.enfant)) group by")
/*	@Query("select e.Jardin from Enfant e ,Jardin j where e.Jardin=j.idjardin")
	public List<Long> CA2(); 
	@Query("select i from Inscription i where i.enfant in (select e.Jardin from Enfant e ,Jardin j  where e.Jardin=j.idjardin) group by month(dateoperation)")
		 public List<Inscription>  CAdate(); */
	 @Query("select adressejardin from Jardin group by adressejardin ")
	    public List<String> findbyadresse();
}
