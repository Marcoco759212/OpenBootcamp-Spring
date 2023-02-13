package com.mahr.obspringdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.mahr.entities.Book;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BookControllerTest {
	
	private TestRestTemplate testRestTemp;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@LocalServerPort
	private int port;
	
	@BeforeEach
	void setUp() {
		restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
		testRestTemp = new TestRestTemplate(restTemplateBuilder);
	}
	
	@DisplayName("Comprobar hola mundo desde controladores Srping REST")
	@Test
	void hello() {
		ResponseEntity<String> response = testRestTemp.getForEntity("/hola", String.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		assertEquals("Hola mundoo", response.getBody());
	}
	
	@Test
	void testFindAll() {
		ResponseEntity<Book[]> response = testRestTemp.getForEntity("/api/books", Book[].class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		
		List<Book> books = Arrays.asList(response.getBody());
		System.out.println(books.size());
	}

	@Test
	void testFindOneById() {
		ResponseEntity<Book> response = testRestTemp.getForEntity("/api/books/1", Book.class);
		
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		

	}

	@Test
	void testCreateBook() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String json = """
				{
				  "title": "Libro creado desde SpringTest",
				  "author": "Java",
				  "pages": 650,
				  "price": 19.99,
				  "releaseDate": "2023-02-12",
				  "online": true
				}
				""";
		HttpEntity<String> request = new HttpEntity<>(json, headers);
		
		ResponseEntity<Book> reposnse = testRestTemp.exchange("/api/books", HttpMethod.POST, request, Book.class);
		
		Book result = reposnse.getBody();
		
		assertEquals(1L, result.getId());
		assertEquals("Libro creado desde SpringTest", result.getTitle());
	}

}
