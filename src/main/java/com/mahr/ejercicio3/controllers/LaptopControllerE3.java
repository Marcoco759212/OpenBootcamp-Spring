package com.mahr.ejercicio3.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mahr.ejercicio2.entities.Laptop;
import com.mahr.ejercicio2.repositories.LaptopRepository;

@RestController
public class LaptopControllerE3 {
	
	LaptopRepository lapRepo;

	public LaptopControllerE3(LaptopRepository lapRepo) {
		this.lapRepo = lapRepo;
	}

	@RequestMapping( value = { "/api/setlaptop" }, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public Laptop setLaptop(@RequestBody Laptop lap) {
		System.out.println("obketo mandado: "+lap);
		lapRepo.save(lap);
		return lap;
	}
}
