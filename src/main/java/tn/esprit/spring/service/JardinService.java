package tn.esprit.spring.service;
import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;

import tn.esprit.spring.service.EnfantService;
import org.springframework.stereotype.Service;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Inscription;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.repository.JardinRepository;
//import tn.esprit.spring.service.*;
//import tn.esprit.spring.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.data.jpa.repository.Query;



@Service
public class JardinService  {

	@Autowired
	JardinRepository jardinRepository;
	@Autowired
	EnfantService enfantService;
	@Autowired
	InscriptionService inscriptionService;
	
	public List <Jardin> GetJardin(){
		return jardinRepository.findAll();
	}
	public List <Enfant> bbb(long idjardin){
        List<Enfant> s = enfantService.GetEnfant();
		List<Enfant> enf = new ArrayList<>();
		 for (Enfant in : s) {
			// System.out.print(inscri.getJardin().getIdjardin());
		       if (in.getJardin().getIdjardin()==idjardin) {
		        	
		            enf.add(in);
		        }
		 }
		
		        return enf;
	}
     public List <Enfant> GetEnfantsBus(Long idjardin){
		
		List<Jardin> jardins = this.GetJardin();
		List<Enfant> enfant = new ArrayList<>();
		
		
		 for (Enfant j : enfant) {
		        if (j.getJardin().getIdjardin()== idjardin) {
		        	
		        	enfant.add(j);
		        	/*IdenfantBus.add(inscri.getEnfant().getIdenfant());
		        	PrenomEnfant.add(inscri.getEnfant().getNomenfant());
		        	NomEnfant.add(inscri.getEnfant().getPrenomenfant();
		            Collections.addAll(IdenfantBus, PrenomEnfant,NomEnfant);*/
		            
		        }
		 }
		 System.out.print(enfant);
		        return enfant;
		
	}
 	public Jardin GetJardinbyid(long idJardin){
		return jardinRepository.findById(idJardin).orElseThrow(null);
	
	}
	public Jardin GetJardinbyName(String nomjardin) {
		return jardinRepository.findByNomjardin(nomjardin);
	
	}
	public List<String> findbytypenumber() {
		// TODO Auto-generated method stub
		return  jardinRepository.findbyadresse();
	}
	public List<Jardin> GetJardinbyAdreese(String adresse) {
		return jardinRepository.findByAdressejardin(adresse);
	
	}
	/*public List <JardinEnfant> GetJardinbyname(string nameJardin){
		return jardinEnfantRepository.findBy(example, queryFunction)(idJardin);
	}*/
	public Jardin addJardinEnfant(Jardin jardinEnfant) {
		return jardinRepository.save(jardinEnfant);
	}
	
	public void deleteJardinEnfant(Long idJardin) {
		jardinRepository.deleteById(idJardin);
		
	}
	public Jardin UpdateJardin(Jardin jardinEnfant){
		Jardin existingJardin = jardinRepository.findById(jardinEnfant.getIdjardin()).orElse(null);
		existingJardin.setDescription(jardinEnfant.getDescription());
		existingJardin.setEmailjardin(jardinEnfant.getEmailjardin());
		existingJardin.setAdressejardin(jardinEnfant.getAdressejardin());
		existingJardin.setLogo(jardinEnfant.getLogo());
		existingJardin.setNomjardin(jardinEnfant.getNomjardin());
		existingJardin.setNumtel(jardinEnfant.getNumtel());
		existingJardin.setTarif(jardinEnfant.getTarif());
		return jardinRepository.save(jardinEnfant);
	}
//select sum(j.tarif) from Jardin j where (j.idjardin = (select e.Jardin from Enfant e ,Inscription inscri  where e.idenfant=inscri.enfant)) group by j.adressejardin")
public List<Integer> CAJardin(Long idjardin){
		
		
		List<Jardin> jardins = this.GetJardin();
		
		List<Jardin> j = new ArrayList<>();
		List<Enfant> e = new ArrayList<>();
		//List<Inscription> lista = new ArrayList<>();
		List<Inscription> Janvi = new ArrayList<>();
		List<Inscription> fev = new ArrayList<>();
		List<Inscription> mars = new ArrayList<>();
		List<Inscription> av = new ArrayList<>();
		List<Inscription> mai = new ArrayList<>();
		List<Inscription> Juin = new ArrayList<>();
		List<Inscription> Jui = new ArrayList<>();
		List<Inscription> arout = new ArrayList<>();
		List<Inscription> sep = new ArrayList<>();
		List<Inscription> oc = new ArrayList<>();
		List<Inscription> nov = new ArrayList<>();
		List<Inscription> dec = new ArrayList<>();
		List<Enfant> e2 = new ArrayList<>();
		List<Inscription> inscri = new ArrayList<>();
		List<Enfant> enfants = enfantService.GetEnfant();
		//List<Inscription> inscriptions = inscriptionService.GetInscriptions();
		//List<Inscription> listpardate =  jardinRepository.CAdate();
		//List<Integer> month = new ArrayList<>();
		List<Integer> month = new ArrayList<>();
		
		List<Inscription> lista = inscriptionService.a(idjardin);
		List<Inscription> ins = inscriptionService.GetInscriptions();
		
		  
		
			for(int i=0;i<lista.size();i++){
				  switch (lista.get(i).getDateoperation().getMonth()) {
			        case 1:
			        	Janvi.add(lista.get(i)); 
			            break;
			        case 2:
			            fev.add(lista.get(i));
			            break;
			        case 3:
			            mars.add(lista.get(i));
			            break; 
			        case 4:
			            av.add(lista.get(i));
			            break; 
			        case 5:
			            mai.add(lista.get(i));
			            break; 
			        case 6:
			           Juin.add(lista.get(i));
			            break; 
			        case 7:
			            Jui.add(lista.get(i));
			            break; 
			        case 8:
			            arout.add(lista.get(i));
			            break; 
			        case 9:
			            sep.add(lista.get(i));
			            break; 
			        case 10:
			            oc.add(lista.get(i));
			            break; 
			        case 11:
			            nov.add(lista.get(i));
			            break;
			        case 12:
			            dec.add(lista.get(i));
			            break; 
			    }
			}
			//System.out.print("hihihihihihihihihiihihihihih");
			//Sy/stem.out.print(Jui);
			for(int i=0;i<Janvi.size();i++)
			{
				int sum = 0;
				sum += Janvi.get(i).getMontant();
				month.add(sum);
				
			}
			for(int i=0;i<fev.size();i++)
			{ 
				int sum2 = 0;
				 sum2 += fev.get(i).getMontant();
				 month.add(sum2);
				
			}
			for(int i=0;i<mars.size();i++)
			{ 
				int sum3 = 0;
				 sum3 += mars.get(i).getMontant();
				 month.add(sum3);
				
			}
			for(int i=0;i<av.size();i++)
			{ 
				int sum4 = 0;
				 sum4 += av.get(i).getMontant();
				 month.add(sum4);
				
			}
			for(int i=0;i<mai.size();i++)
			{ 
				int sum5 = 0;
				 sum5 += mai.get(i).getMontant();
				 month.add(sum5);
				
			}
			for(int i=0;i<Juin.size();i++)
			{ 
				int sum6 = 0;
				 sum6 += Juin.get(i).getMontant();
				 month.add(sum6);
				
			}
			for(int i=0;i<Jui.size();i++)
			{ 
				int sum7 = 0;
				 sum7 += Jui.get(i).getMontant();
				 month.add(sum7);
				
			}
			for(int i=0;i<arout.size();i++)
			{ 
				int sum8 = 0;
				 sum8 += arout.get(i).getMontant();
				 month.add(sum8);
				
			}
			for(int i=0;i<sep.size();i++)
			{ 
				int sum9 = 0;
				 sum9 += sep.get(i).getMontant();
				 month.add(sum9);
				
			}
			for(int i=0;i<oc.size();i++)
			{ 
				int sum10 = 0;
				 sum10 += oc.get(i).getMontant();
				 month.add(sum10);
				
			}
			for(int i=0;i<nov.size();i++)
			{ 
				int sum11 = 0;
				 sum11 += nov.get(i).getMontant();
				 month.add(sum11);
				
			}
			for(int i=0;i<dec.size();i++)
			{ 
				int sum12 = 0;
				 sum12 += dec.get(i).getMontant();
				 month.add(sum12);
				
			}
			
		
		
		
		
		
		return  month;
		}
/*	public List<Inscription> CA(){
		return jardinRepository.CAdate();}
	public List<Long> CA2(){
		return jardinRepository.CA2();}*/
	public List<Inscription> a(Long idjardin){

		List<Inscription> lista = new ArrayList<>();
		for(Inscription i1 : lista){
			if(i1.getEnfant().getJardin().getIdjardin() == idjardin){
			//	System.out.print(i1.getEnfant().getJardin().getIdjardin());
		    lista.add(i1);
		    }}
		return lista;
	}
	
	
	
}