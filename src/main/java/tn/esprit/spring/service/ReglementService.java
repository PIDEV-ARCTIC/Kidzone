package tn.esprit.spring.service;
import static org.hamcrest.CoreMatchers.nullValue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Reglement;
import tn.esprit.spring.repository.ReglementRepository;
import tn.esprit.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class ReglementService  {

	@Autowired
	ReglementRepository reglementRepository;
	
	
	public Reglement addReglement(Reglement r) {
		return reglementRepository.save(r);
	}
	public void deleteReglement(long id) {
		// TODO Auto-generated method stub
		reglementRepository.deleteById(id);
	}
	public Reglement updateReglement(Reglement r) {
		// TODO Auto-generated method stub 
		return reglementRepository.save(r);
	}
	public List <Reglement> GetReglement(){
		return reglementRepository.findAll();
	}
	public Reglement FindReglement(long id){
		return reglementRepository.findById(id).get();
	}
	/*public String FindMailF(long id){
		 return reglementRepository.findById(id).get().getFournisseurs().getMailfournisseur();
	}
	public String FindMailE(long id){
		 return reglementRepository.findById(id).get();
	}
	public String FindMailENF(long id){
		 return reglementRepository.findById(id).get().getEnfants().getMail();
	}*/
	public Reglement UpdateReglement(Reglement r){
		Reglement existingReglement = reglementRepository.findById(r.getIdreglement()).orElse(null);
		
		return reglementRepository.save(r);
	}
	
	public List<Reglement> EtatDeCaisse( ){
		
		return reglementRepository.EtatCaisse();
	}

public int EtatDeCaisseDet( ){
		
		return reglementRepository.EtatCaisseDet();
	}
public int EtatDeCaisseChec( ){
	
	return reglementRepository.EtatCaissechec();
}
public int EtatDeCaisseESS( ){
	
	return reglementRepository.EtatCaisseEss();
}
public int EtatDeCaisseDett( ){
	
	return reglementRepository.EtatCaisseT();
}
public int EtatDeCaisseDetCart( ){
	
	return reglementRepository.EtatCaisseCart();
}


	public List<Reglement> Echfourn( ){
		
		return reglementRepository.EcheanceFourn();
	}
public List<String> Stat1( ){
		
		return reglementRepository.stat1();
	}

public List<Long> Stat2( ){
	
	return reglementRepository.stat2();
}

	
public List<Reglement> Echanf( ){
		
		return reglementRepository.EcheanceClient();
	}
public String Alert( ){
	String alert =null;
	List<Reglement> reglements=this.GetReglement();
List<String> debits =new ArrayList();
List<String> credits =new ArrayList();
for (Reglement r :reglements){
	if(r.getSensoperation() =="Credit"){
		credits.add(r.getSensoperation());
		}
	else {
		debits.add(r.getSensoperation());
	}
}


	int c=credits.size();
	int d=debits.size();
	if(c>d){
		 alert="jawwekk fisfis";
	}
	else if(c<d){
	 alert="bsara7a rakk sfirr";
	}
	else {
		 alert="t3adi rouhikk ";
	}
	

	return alert;
	
}
	
	/*
	*/

}
