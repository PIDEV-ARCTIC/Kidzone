package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Enfant;

public interface EnfantRepository extends JpaRepository<Enfant,Long> {

}
