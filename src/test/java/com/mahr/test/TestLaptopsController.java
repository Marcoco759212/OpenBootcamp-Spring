package com.mahr.test;

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

import com.mahr.entities.Laptop;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TestLaptopsController {
	
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

	@DisplayName("Obtener laptop por id")
	@Test
	void testGetLaptopById() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = """
				  {
					    "marca": "HP",
					    "modelo": "zbook",
					    "caracteristicas": "64GB RAM, 3TB SSD, Intel Xeon",
					    "precio": 3500.99,
					    "stock": true
					  },
					  {
					    "marca": "DELL",
					    "modelo": "workstatin",
					    "caracteristicas": "64GB RAM, 3TB SSD, Intel Xeon",
					    "precio": 3500.99,
					    "stock": true
					  }
				""";
		HttpEntity<String> request = new HttpEntity<>(json, headers);
		testRestTemp.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
		ResponseEntity<Laptop> response = testRestTemp.getForEntity("/api/laptops/1", Laptop.class);
		
		System.out.println(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@DisplayName("Crear Laptop")
	@Test
	void testCreateLaptop() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String json = """
				{
					"marca": "Alienware",
					"modelo": "workstation",
					"caracteristicas": "Ultra",
					"precio": 2000,
					"stock": true
				}
				""";
		HttpEntity<String> request = new HttpEntity<>(json, headers);
		
		ResponseEntity<Laptop> reposnse = testRestTemp.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
		
		Laptop result = reposnse.getBody();
		
		assertEquals(1L, result.getId());
		assertEquals("Alienware", result.getMarca());
	}

	@DisplayName("Editar laptop")
	@Test
	void testUpdtaeLaptop() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		String json = """
				{
					"id" : 2,
					"marca": "Alienware",
					"modelo": "workstation",
					"caracteristicas": "Laptop editada desde SpringTest",
					"precio": 2000,
					"stock": true
				}
				""";
		HttpEntity<String> request = new HttpEntity<>(json, headers);
		
		ResponseEntity<Laptop> reposnse = testRestTemp.exchange("/api/laptops", HttpMethod.PUT, request, Laptop.class);
		
		Laptop result = reposnse.getBody();
		
		assertEquals(2L, result.getId());
		assertEquals("Laptop editada desde SpringTest", result.getCaracteristicas());
	}

	@DisplayName("Eliminar laptop por id")
	@Test
	void testDeleteBook() {
		
		ResponseEntity<Laptop> response ;
		
		response = testRestTemp.getForEntity("/api/laptops/1", Laptop.class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
		testRestTemp.delete("/api/laptops/1");
		
		response = testRestTemp.getForEntity("/api/laptops/1", Laptop.class);
		
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@DisplayName("Eliminar todas las laptops")
	@Test
	void testDeleteAllBooks() {
		testRestTemp.delete("/api/laptops");
		
		ResponseEntity<Laptop[]> response = testRestTemp.getForEntity("/api/laptops", Laptop[].class);
		
		List<Laptop> books = Arrays.asList(response.getBody());
		assertEquals(books.size(), 0);
	}
	
	@DisplayName("Obtener todas las laptops")
	@Test
	void testGetAllLaptops() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = """
				  {
					    "marca": "HP",
					    "modelo": "zbook",
					    "caracteristicas": "64GB RAM, 3TB SSD, Intel Xeon",
					    "precio": 3500.99,
					    "stock": true
					  },
					  {
					    "marca": "DELL",
					    "modelo": "workstatin",
					    "caracteristicas": "64GB RAM, 3TB SSD, Intel Xeon",
					    "precio": 3500.99,
					    "stock": true
					  }
				""";
		HttpEntity<String> request = new HttpEntity<>(json, headers);
		testRestTemp.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
		
		ResponseEntity<Laptop[]> response = testRestTemp.getForEntity("/api/laptops", Laptop[].class);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		
		List<Laptop> books = Arrays.asList(response.getBody());
		System.out.println(books.size());
		
	}

}
