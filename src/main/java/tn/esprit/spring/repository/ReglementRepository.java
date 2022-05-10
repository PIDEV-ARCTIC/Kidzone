package tn.esprit.spring.repository;

import tn.esprit.spring.Entity.Fournisseur;
//import tn.esprit.spring.Entity.Stat1;
import tn.esprit.spring.Entity.Reglement;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReglementRepository  extends JpaRepository<Reglement, Long> {

	//@Query(" Select r from Reglement r where (r.dateoperation>= month(now())-1 ) and (r.dateoperation<= month(now())-1) and (r.sensoperation='Credit')")
	@Query(" Select r from Reglement r where (r.dateoperation = CURDATE()) and (r.sensoperation= 'Credit')   ")
    public List<Reglement> EtatCaisse();
	
	@Query(" Select sum(r.montant) from Reglement r where (r.dateoperation = CURDATE()) and (r.sensoperation= 'Credit')   ")
	public int EtatCaisseDet();
	
	@Query(" Select sum(r.montant) from Reglement r where (r.dateoperation = CURDATE()) and (r.sensoperation= 'Credit') and(r.mode='Chec')   ")
	public int EtatCaissechec();
	
	@Query(" Select sum(r.montant) from Reglement r where (r.dateoperation = CURDATE()) and (r.sensoperation= 'Credit') and(r.mode='Essepesse')   ")
	public int EtatCaisseEss();
	
	@Query(" Select sum(r.montant) from Reglement r where (r.dateoperation = CURDATE()) and (r.sensoperation= 'Credit') and(r.mode='Traite')   ")
	public int EtatCaisseT();
	
	@Query(" Select sum(r.montant) from Reglement r where (r.dateoperation = CURDATE()) and (r.sensoperation= 'Credit') and(r.mode='Carte ')   ")
	public int EtatCaisseCart();
	
	@Query(" Select r from Reglement r where (r.dateeche = CURDATE()) and (r.sensoperation= 'Credit')   and (r.type= 'Enfant')  and (r.mode= 'Chec') ")
	public List<Reglement> EcheanceClient();
	
	@Query(" Select r from Reglement r where (r.dateeche = CURDATE()) and (r.sensoperation= 'Debit')   and (r.type= 'Fournisseur')  and (r.mode= 'Chec') ")
	public List<Reglement> EcheanceFourn();
	@Query(" Select r.sensoperation from Reglement r where (r.dateeche = CURDATE()) and (r.mode= 'Chec')   ")
	public List<String> stat1();
	@Query(" Select sum(r.montant)   from Reglement r where (r.dateeche = CURDATE())  and (r.mode= 'Chec') group by sensoperation")
	public List<Long> stat2();
	
	

}
