package com.mahr.obspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpringdatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringdatajpaApplication.class, args);
		
		CocheRepository repository = context.getBean(CocheRepository.class);
		
		System.out.println("find");
		System.out.println("El numero de coches guardados es" + repository.count());

		Coche toyota = new Coche(null, "Toyota", "Pyrus", "2010");
		repository.save(toyota);
		
		System.out.println("El numero de coches guardados es" + repository.count());
		
		System.out.println(repository.findAll());
	}

}
