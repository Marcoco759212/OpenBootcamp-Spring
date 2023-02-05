package com.mahr.ejercicio3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RunEjercicio3 {
	public static void main(String[] args) {
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("//         Ejercicio 3 - Spring Data JPA y H2 Database          ");
		System.out.println("////////////////////////////////////////////////////////////////");
		ApplicationContext context = SpringApplication.run(RunEjercicio3.class, args);
		
		PersonaRepository personaRepository = context.getBean(PersonaRepository.class);
		
		Persona persona = new Persona(null, "Marco", "Hernández", "26", "México");
		personaRepository.save(persona);
		System.out.println(personaRepository.findAll());
		
	}
}
