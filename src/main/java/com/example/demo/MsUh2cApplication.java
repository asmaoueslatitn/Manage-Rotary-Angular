package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@RestController("*")


public class MsUh2cApplication implements CommandLineRunner {
	@Autowired

	private EtudiantRepository etudiantRepository ; 
	@Autowired

	private FormationRepository formationRepository ; 
	@Autowired
	
	 ImageRepository imageRepository;
	private RepositoryRestConfiguration repositoryRestConfiguration ; 
	
	public static void main(String[] args) {
		SpringApplication.run(MsUh2cApplication.class, args);
		
	}

	@Override
	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		// image 1
		 ClassPathResource backImgFile = new ClassPathResource("static/image/DavisCarolyn.jpg");
		 byte[] arrayPic = new byte[(int) backImgFile.contentLength()];
		 backImgFile.getInputStream().read(arrayPic);
		 ImageModel blackImage = new ImageModel(1, "JSA-ABOUT-IMAGE-BLACK-BACKGROUND", "jpg", arrayPic);
		
	ImageModel m1= imageRepository.save(blackImage);
		 for(ImageModel imageModel : imageRepository.findAll()){
			 Files.write(Paths.get("bin/retrieve-dir/" + imageModel.getName() + "." + imageModel.getType()), imageModel.getPic());
			 }
		
       Formation f1 = formationRepository.save(new Formation(null,"php" ,30 ,null)) ;
       Formation f2 = formationRepository.save(new Formation(null,"java" ,30 ,null)) ;
       Formation f3 = formationRepository.save(new Formation(null,"oracle" ,30 ,null)) ;
       Formation f4 = formationRepository.save(new Formation(null,"Springboot" ,30 ,null)) ;



		 
	 Etudiant save = etudiantRepository.save( new Etudiant (null ,"asma" , "oueslati",new Date(),f1 ));

	
		
	}

	
	

}

