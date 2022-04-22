package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Employee;
@Repository
public interface repositoryEmployee extends JpaRepository<Employee, Long> {

	@Query("SELECT p FROM Employee p WHERE "
			+ "p.nomEmployee LIKE %?1%"
			+ "OR p.prenomEmployee LIKE %?1%"
			+ "OR p.mail LIKE %?1%"
			
			)
	public List<Employee> findAll(String keyword);
}
