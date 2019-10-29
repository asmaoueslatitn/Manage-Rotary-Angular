package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.EnumTranslationConfiguration;
import org.springframework.data.rest.core.config.MetadataConfiguration;
import org.springframework.data.rest.core.config.ProjectionDefinitionConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


@Configuration
public class GlobalRepositoryRestConfigurer implements  RepositoryRestConfigurer  {
@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.setReturnBodyOnCreate(true) ; 
		repositoryRestConfiguration.setReturnBodyOnUpdate(true) ; 
		repositoryRestConfiguration.exposeIdsFor(Etudiant.class,Formation.class) ; 
		repositoryRestConfiguration.getCorsRegistry()
		.addMapping("/**")
		.allowedOrigins("http://localhost:4200")
		.allowedHeaders("*")
		.allowedMethods("OPTIONS","HEAD","GET","PUT","POST","DELETE","PATCH") ;
		
	}
	}


