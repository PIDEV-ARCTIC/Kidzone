package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entity.Bus;

public interface BusRepository extends JpaRepository<Bus,Long> {
	
}
