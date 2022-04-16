package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Employee;
import tn.esprit.spring.repositories.repositoryEmployee;

@Service
public class serviceEmployee implements DAOservices<Employee>{

	@Autowired
	repositoryEmployee re;
	@Override
	public Employee add(Employee s) {

		return re.save(s);
	}

	@Override
	public Employee update(Employee s, Long id) {
		Employee employeeExist = re.findById(id).orElseThrow(null);
		employeeExist.setMail(s.getMail());
		employeeExist.setNomEmployee(s.getNomEmployee());
		employeeExist.setPrenomEmployee(s.getPrenomEmployee());
		employeeExist.setTelEmployee(s.getTelEmployee());
		re.save(employeeExist);
		return employeeExist;
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

	@Override
	public List<Employee> getall() {
		return re.findAll();
	}

}
