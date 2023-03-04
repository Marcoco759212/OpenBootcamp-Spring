package com.mahr.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mahr.entities.Laptop;
import com.mahr.repositories.LaptopRepository;

@RestController
public class LaptopController {

	private final Logger log = LoggerFactory.getLogger(LaptopController.class);
	
	@Value("${app.message}")
	String message;
	
	LaptopRepository lapRepo;

	public LaptopController(LaptopRepository lapRepo) {
		this.lapRepo = lapRepo;
		

	}

	//CRUD Laptop
	
	// findAll()
	@GetMapping("/api/laptops")
	public List<Laptop> getAllLaptops(){
		log.info("#########Ambiente "+message+"#########");
		log.info("Consultando lista de laptops");
		return lapRepo.findAll();
	}
	
	// findOneById()
	
	@GetMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> getLaptopById(@PathVariable Long id){
		log.info("#########Ambiente "+message+"#########");
		log.info("Entra id: " + id);
		Optional<Laptop> laptop = lapRepo.findById(id);
		log.info("Consultando laptop por id: " + laptop.get());

		return laptop.isPresent() ? ResponseEntity.ok(laptop.get()) : ResponseEntity.notFound().build();
	}
	
	// create()
	@PostMapping("/api/laptops")
	public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop lap, @RequestHeader HttpHeaders headers) {
		log.info("#########Ambiente "+message+"#########");
		if(lap.getId() != null) {
			log.warn("Trying to create a book with id");
			System.out.println("Trying to create a book with id");
			return ResponseEntity.badRequest().build();
		}
		Laptop result = lapRepo.save(lap);
		
		log.info("Insertando laptop: " + lap);
		
		return ResponseEntity.ok(result);
	}
	
	// update()
	@PutMapping("/api/laptops")
	public ResponseEntity<Laptop>  updtaeLaptop(@RequestBody Laptop lap) {
		log.info("#########Ambiente "+message+"#########");
		if(lap.getId() == null) {
			log.warn("Se intentó insertar una laptop"); 
			return ResponseEntity.badRequest().build();
		}
		if(!lapRepo.existsById(lap.getId())){
			log.warn("Se intentó actualizar una laptop inexistente");
			return ResponseEntity.notFound().build();
		}
		Laptop result = lapRepo.save(lap);
		log.info("actualizando laptop: " + lap);
		return ResponseEntity.ok(result);
	}
	
	// delete()
	@DeleteMapping("/api/laptops/{id}")
	public ResponseEntity<Laptop> deleteBook(@PathVariable Long id){
		log.info("#########Ambiente "+message+"#########");
		
		if(!lapRepo.existsById(id)){
			log.warn("Se intentó eliminar una laptop inexistente");
			return ResponseEntity.notFound().build();
		}
		
		lapRepo.deleteById(id);
		log.info("Eliminando laptop por id: " + id);
		
		return ResponseEntity.noContent().build();
	}
	
	// deleteAll()
	@DeleteMapping("/api/laptops")
	public ResponseEntity<Laptop> deleteAllBooks(){
		log.info("#########Ambiente "+message+"#########");
		
		lapRepo.deleteAll();
		log.info("Se han eliminado todas las laptops");
		
		return ResponseEntity.noContent().build();
	}
	
}
