package tn.esprit.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.Cours;





public interface Icours {
	Cours ajouterCours(Cours c );
	
	//void eya(long  idcours);
	//void delours(long  idcours);
	List<Cours>getallCours();
	public Cours updateCours(Cours c);
	List<Cours> search(String keyword);
	 public void saveImage(MultipartFile file);

	void delete(long idcours);	
	
}
