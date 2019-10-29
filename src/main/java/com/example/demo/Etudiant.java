package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Generated;
import javax.imageio.ImageIO;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Etudiant {
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ; 
	private String  nom ; 
	private String  prenom ; 
	private Date dateNaissance ;

	@ManyToOne
	private Formation formation ; 
	

	
	
	

}
