package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entity.Bus;
import tn.esprit.spring.repository.BusRepository;

@Service
public class BusService {
	
	@Autowired
	private BusRepository busRepository;
	
	public Bus AddBus(Bus inscription){
		return busRepository.save(inscription);
	}
	
	public List <Bus> GetBus(){
		return busRepository.findAll();
	}
	
	public Bus FindBus(long idbus){
		return busRepository.findById(idbus).get();
	}
	
	
	public String DeleteBus(long idbus){
		busRepository.deleteById(idbus);
		return " Bus numéro  " + idbus + " est supprimé ";
	}
	
	public Bus UpdateBus(Bus bus){
		Bus existingBus =busRepository.findById(bus.getIdbus()).orElse(null);
		existingBus.setHeuredepart(bus.getHeuredepart());
		existingBus.setDestination(bus.getDestination());
		existingBus.setNbrplaces(bus.getNbrplaces());
		return busRepository.save(bus);
	}
	
	

}
