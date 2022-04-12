package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.Entity.Cours;



public interface CoursRepository extends CrudRepository<Cours, Long> {

}
