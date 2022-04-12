package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Entity.Employee;
@Repository
public interface repositoryEmployee extends JpaRepository<Employee, Long> {

}
