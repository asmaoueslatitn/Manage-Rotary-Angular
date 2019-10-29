package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;



public interface FormationRepository  extends JpaRepository<Formation, Long>{
	
	

}
