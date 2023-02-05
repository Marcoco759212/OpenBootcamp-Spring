package com.mahr.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahr.entities.Book;
import com.mahr.repositories.BookRepository;

@RestController
public class BookController {
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
	
	
	// Crear un nuevo libro en la base de datos
	
	
	// Actualizar un libro en la base de datos
	
	
	// Borrar un libro en la base de datos
}
