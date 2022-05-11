package tn.esprit.spring.service;

import tn.esprit.spring.entity.Jardin;

public interface IJardin {
	
	public Jardin addJardinEnfant(Jardin jardinEnfant);
	public void deleteJardinEnfant(Long idJardin);
}
