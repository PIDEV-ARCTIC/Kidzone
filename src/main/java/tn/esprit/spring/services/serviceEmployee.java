package tn.esprit.spring.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class serviceEmployee /*implements DAOservices<Employee> */{
/*
	private Path foundFile;
	@Autowired
	private final repositoryEmployee re;

	@Autowired
	public serviceEmployee(repositoryEmployee re) {
		this.re = re;
	}

	@Override
	public Employee add(Employee s) {

		return re.save(s);
	}

	@Override
	public List<Employee> getall() {

		return re.findAll();
	}

	@Override
	public Employee getByid(Long id) {
		return re.findById(id).orElseThrow(null);
	}

	@Override
	public Employee delete(Long id) {
		re.deleteById(id);
		return null;
	}

	public Resource getFile(String filecode) throws IOException {
		Path uploadDirectory = Paths.get("Files-upload");
		Files.list(uploadDirectory).forEach(file -> {
			if (file.getFileName().toString().startsWith(filecode)) {
				foundFile = file;
				return;/////////////////////////////////////////
			}
		});
		if (foundFile != null) {
			return (Resource) new UrlResource(foundFile.toUri());
		}
		return null;
	}

	public String saveFile(String fileName, MultipartFile multipartFile) throws IOException {
		Path uploadDirectory = Paths.get("Files-upload");
		String fileCode = RandomStringUtils.randomAlphanumeric(8);

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadDirectory.resolve(fileCode + "-" + fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Error saving file: " + fileName, ioe);

		}
		return fileCode;
	}



	@Override
	public Employee update(Employee s) {
		re.save(s);
		return s;
	}
*/
}
