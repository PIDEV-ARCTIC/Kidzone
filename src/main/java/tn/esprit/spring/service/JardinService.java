package tn.esprit.spring.service;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.spring.service.EnfantService;
import org.springframework.stereotype.Service;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import tn.esprit.spring.entity.Enfant;
import tn.esprit.spring.entity.Jardin;
import tn.esprit.spring.repository.JardinRepository;
//import tn.esprit.spring.service.*;
//import tn.esprit.spring.service.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;



@Service
public class JardinService  {

	@Autowired
	JardinRepository jardinRepository;
	@Autowired
	EnfantService enfantService;
	
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
	public List<Long> CAJardinEnfant(){
		return jardinRepository.CA();
		}
	
	
}