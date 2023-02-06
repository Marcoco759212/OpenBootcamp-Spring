package com.mahr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mahr.ejercicio2.entities.Laptop;
import com.mahr.ejercicio2.repositories.LaptopRepository;


@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);

		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
		
		//CRUD
		//Crear un libro

		Laptop lap = new Laptop(null, "HP", "zbook", "64GB RAM, 3TB SSD, Intel Xeon", 3500.99, true);
		
		Laptop lap2 = new Laptop(null, "DELL", "workstatin", "64GB RAM, 3TB SSD, Intel Xeon", 3500.99, true);
		
		//Almacenar un libro		
		laptopRepository.save(lap);
		laptopRepository.save(lap2);

	}
}
