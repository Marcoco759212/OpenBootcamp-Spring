package com.mahr.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.mahr.entities.Book;
import com.mahr.repositories.BookRepository;

@RestController
public class BookController {
	private final Logger log = LoggerFactory.getLogger(BookController.class);
	
	//Atributes
	BookRepository bookRepo;
	
	//Constructor
	public BookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	// CRUD sobre la entidad Bokk
	
	// Buscar todos los libros
	@GetMapping("/api/books")
	public List<Book> findAll() {
		return bookRepo.findAll();
	}

	// Buscar un solo libro por Id
	@GetMapping("/api/books/{id}")
	public ResponseEntity<Book> findOneById(@PathVariable Long id){
		Optional<Book> bookOpt = bookRepo.findById(id);
		
		if(bookOpt.isPresent()) {
			return ResponseEntity.ok(bookOpt.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	// Crear un nuevo libro en la base de datos
	@PostMapping("/api/books")
	public ResponseEntity<Book> createBook(@RequestBody Book book, @RequestHeader HttpHeaders headers) {
		System.out.println(headers.get("User-Agent"));
		if(book.getId() != null) {// si existe el id no se debe crear el objeto por que es una actualziaci[on
			log.warn("Trying to create a book with id");
			System.out.println("Trying to create a book with id");
			return ResponseEntity.badRequest().build();
		}
		Book result = bookRepo.save(book);
		return ResponseEntity.ok(result);
	}
	
	// Actualizar un libro en la base de datos
	@PutMapping("/api/books")
	public ResponseEntity<Book>  updtaeBook(@RequestBody Book book) {
		if(book.getId() == null) {// si no existe el id es un create
			log.warn("Trying to update a book with id");
			System.out.println("Trying to update a book with id");
			return ResponseEntity.badRequest().build();
		}
		if(!bookRepo.existsById(book.getId())){
			log.warn("Trying to update a no existing book");
			System.out.println("Trying to update a no existing book");
			return ResponseEntity.notFound().build();
		}
		Book result = bookRepo.save(book);
		return ResponseEntity.ok(result);
	}
	
	// Borrar un libro en la base de datos
	@DeleteMapping("/api/books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Long id){
		
		if(!bookRepo.existsById(id)){
			log.warn("Trying to update a no existing book");
			System.out.println("Trying to delete a no existing book");
			return ResponseEntity.notFound().build();
		}
		
		bookRepo.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/api/books")
	public ResponseEntity<Book> deleteAllBooks(){
		
		log.info("REST Request for deleting all books");
//		
		bookRepo.deleteAll();
		
		return ResponseEntity.noContent().build();
	}
}
