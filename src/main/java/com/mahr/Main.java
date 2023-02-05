package com.mahr;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mahr.entities.Book;
import com.mahr.repositories.BookRepository;

@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);
		BookRepository bookRepo = context.getBean(BookRepository.class);
		
		//CRUD
		//Crear un libro
		Book book = new Book(
						null, "Homo Deus", "Yuval Noah", 450, 
						29.99, LocalDate.of(2018, 12, 1), true
					);
		Book book2 = new Book(
				null, "Homo Sapiens", "Yuval Noah", 450, 
				29.99, LocalDate.of(2013, 12, 1), true
			);
		
		//Almacenar un libro
		System.out.println("Numero de libros en base de datos: " + bookRepo.findAll().size());
		
		bookRepo.save(book);
		bookRepo.save(book2);
		/*
		//Recuperar un libro/
		System.out.println("Numero de libros en base de datos: " + bookRepo.findAll().size());
		
		//Borrarun libro
		bookRepo.deleteById(1L);
		
		System.out.println("Numero de libros en base de datos: " + bookRepo.findAll().size());
		*/
	}
}
