package tn.esprit.spring.controller;

//import java.io.IOException;
//import java.util.List;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import tn.esprit.spring.Entity.FileUploadResponse;
//import tn.esprit.spring.services.serviceEmail;
//import tn.esprit.spring.services.serviceEmployee;
//@RestController
//@RequestMapping("/api/employee")
//@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
//public class controllerEmployee 
//{
	/*@Autowired
	private serviceEmail sendService;
	@Autowired
	serviceEmployee serviceEmployee;
	@PostMapping("/add")
	private Employee addEmployee(@RequestBody Employee s)
	{
		String pass = RandomStringUtils.randomAlphanumeric(8);
		s.setPassEmployee(pass);
		serviceEmployee.add(s);
		sendService.sendEmail(s.getMail(), "Welcome TO KIDZONE", "Your Password to KIDZONE platform is: "+ pass);
		return s;

	}
	@GetMapping("{id}")
	private Employee getEmployeeById(@PathVariable Long id)
	{
		return serviceEmployee.getByid(id);
	}

	@GetMapping("/all")
	private List<Employee> getAllEmployee()
	{
		return serviceEmployee.getall();
	}	
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = serviceEmployee.update(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }
	@DeleteMapping("/delete/{id}")
	private Employee deleteEmployee( @PathVariable Long id)
	{
		return serviceEmployee.delete(id);
	}
	@PostMapping("/uploadfile")
	public ResponseEntity<FileUploadResponse> uploadFile(
			@RequestParam("file") MultipartFile multipartFile )
					throws IOException
	{
		String fileName= StringUtils.cleanPath(multipartFile.getOriginalFilename());
		long size = multipartFile.getSize();
		String fileCode =serviceEmployee.saveFile(fileName,multipartFile);
		FileUploadResponse response  = new FileUploadResponse();
		response.setFileName(fileName);
		response.setSize(size);
		response.setDownloadUri("/downloadfile/" + fileCode );
		return new ResponseEntity<>(response , HttpStatus.OK);
	}
	@GetMapping("/downloadfile/{filecode}")
	public ResponseEntity<?> downloadFile(@PathVariable ("filecode") String filecode)
	{
		Resource resource = null;

		try {
			resource = serviceEmployee.getFile(filecode);
		} catch (IOException e) {
			return ResponseEntity.internalServerError().build();

		}
		if( resource == null)
		{
			return new ResponseEntity<>("File not found", HttpStatus.NOT_FOUND);
		}
		String contentType="application/octet-stream";
		String headerValue="attachment; filename=\"" + resource.getFilename() + "\"";
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION , headerValue)
				.body(resource);
	}
*/

//}
