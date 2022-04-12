package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Entity.Employee;
import tn.esprit.spring.services.serviceEmployee;
@RestController
@RequestMapping("/api/employee")
public class controllerEmployee 
{
	@Autowired
	serviceEmployee serviceEmployee;
	@PostMapping
	private Employee addEmployee(@RequestBody Employee s)
	{
		return serviceEmployee.add(s);

	}
	@GetMapping("{id}")
	private Employee getEmployeeById(@PathVariable Long id)
	{
		return serviceEmployee.getByid(id);
	}
	@GetMapping
	private List<Employee> getAllEmployee()
	{
		return serviceEmployee.getall();
	}
	@PutMapping("{id}")
	private Employee updateEmployee(@RequestBody Employee s , @PathVariable Long id)
	{
		return serviceEmployee.update(s, id);
	}

}
