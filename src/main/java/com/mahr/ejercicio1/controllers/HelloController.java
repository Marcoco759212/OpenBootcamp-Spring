package com.mahr.ejercicio1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/hola")
	public String hello() {
		return "Hola, este es el resultado del Ejercicio 1";
	}
	
}
