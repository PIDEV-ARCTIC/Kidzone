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

import tn.esprit.spring.entity.Cours;
import tn.esprit.spring.repository.CoursRepository;





@Service

public   class CoursService implements Icours {
	private final Path root = Paths.get("C:/Users/nourE/Desktop/farah/paper-dashboard-angular-master/src/assets/img/ReclamationPic");

	@Autowired
	CoursRepository repo;
	@Override
	public Cours ajouterCours(Cours c) {
		repo.save(c);
		return c;
	}

	//@Override
	//public void eya(long idcours) {
		// repo.deleteById(idcours);
		
	//}
	
	@Override
	public void delete(long idcours) {
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

	/*@Override
	public void delours(long idcours) {
		repo.deleteById(idcours);
		
	}

	
*/
	public void saveImage(MultipartFile  file) {
	    try {
	       Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
	  }


	
	
	}
	
	

	

	


