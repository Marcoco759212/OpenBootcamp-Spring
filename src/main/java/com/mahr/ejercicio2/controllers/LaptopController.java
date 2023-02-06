package com.mahr.ejercicio2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahr.ejercicio2.entities.Laptop;
import com.mahr.ejercicio2.repositories.LaptopRepository;

@RestController
public class LaptopController {
	
	LaptopRepository lapRepo;

	public LaptopController(LaptopRepository lapRepo) {
		super();
		this.lapRepo = lapRepo;
	}

	@GetMapping("/api/laptops")
	public List<Laptop> getAllLaptops(){
		return lapRepo.findAll();
	}
}
