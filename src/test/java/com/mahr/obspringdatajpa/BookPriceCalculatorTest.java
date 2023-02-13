package com.mahr.obspringdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.mahr.entities.Book;
import com.mahr.servicecs.BookPriceCalculator;

class BookPriceCalculatorTest {

	@Test
	void testCalculatePrice() {
		// Configuraci[on de la prueba
		Book book = new Book(1L, "El se;or de los anillos", "Author", 1000, 49.99, LocalDate.now(), true);
		BookPriceCalculator calculator = new BookPriceCalculator();
		
		//Se ejecuta el comportamiento a testear
		double price = calculator.calculatePrice(book);
		System.out.println(price);
		
		// Comprobaciones aserciones
		assertTrue(price > 0);
		assertEquals(57.980000000000004, price);
	}

}
