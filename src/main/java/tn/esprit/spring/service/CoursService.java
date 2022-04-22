package tn.esprit.spring.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import tn.esprit.spring.Entity.Cours;
import tn.esprit.spring.Entity.Reclamation;
import tn.esprit.spring.repository.CoursRepository;

@Service

public   class CoursService implements Icours {
	@Autowired
	CoursRepository repo;
	@Override
	public Cours ajouterCours(Cours c) {
		repo.save(c);
		return c;
	}

	@Override
	public void deletCours(long idcours) {
		 repo.deleteById(idcours);
		
	}

	@Override
	public List<Cours> getallCours() {
		return   (List<Cours>) this.repo.findAll();
	}

	@Override
	public Cours updateCours(Cours c) {
		this.repo.save(c);
		return c;
	}


	
	/*
	
//	public void uploadFile(MultipartFile file) throws IllegalStateException, IOException
//	{
//		file.transferTo(new File("C:\\Users\\Rchouda\\Desktop" + file.getOriginalFilename()));
//	}
	public Resource getFile(String file) throws IOException
	{
		Path uploadDirectory = (Path) Paths.get("Files-upload");
		
		Files.list(uploadDirectory).forEach(file -> 
		{
			if( file.getFileName().toString().startsWith(filecode))
			{
				foundFile = file;
				return ;
			}
		});
		if (foundFile != null )
		{
			return (Resource) new UrlResource(foundFile.toUri());
		}
		return null;
	}
	
	
	
	
	/*
	
	public 	String saveFile(String fileName, MultipartFile multipartFile 	) throws IOException
	{
		Path uploadDirectory= Paths.get("Files-upload");
		String fileCode = RandomStringUtils.randomAlphanumeric(8);

		try (InputStream inputStream = multipartFile.getInputStream())
		{
			Path filePath = uploadDirectory.resolve(fileCode + "-" 	+ fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException ioe)
		{ throw new IOException("Error saving file: " + fileName, ioe);

		}
		return fileCode ;
	}

	
	*/

	@Override
	public List<Cours> search(String keyword) {
		if(keyword != null){
			return repo.search(keyword);

		}
		return repo.search(keyword);
	}

	

	
	
	}
	
	

	

	


