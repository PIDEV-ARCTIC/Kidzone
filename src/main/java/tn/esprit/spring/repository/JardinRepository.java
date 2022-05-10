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
	 Jardin findByIdjardin(long idjardin);
	@Query("select sum(j.tarif) from Jardin j where (j.idjardin = (select e.Jardin from Enfant e ,Inscription inscri  where e.idenfant=inscri.enfant))")
	//@Query("select sum(j.tarif) from Jardin j,Inscription i  group by i.dateoperation")
	 public List<Long> CA(); 
	/*@Query("select i.dateoperation from Inscription i where (i.idjardin = (select e.Jardin from Enfant e ,Inscription inscri  where e.idenfant=inscri.enfant)) group by month(dateoperation)")
		 public List<Date>  CAdate(); */
}
