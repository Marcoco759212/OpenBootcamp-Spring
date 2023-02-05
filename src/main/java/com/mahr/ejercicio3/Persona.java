package com.mahr.ejercicio3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastname;
	private String age;
	private String country;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	public Persona(Long id, String name, String lastname, String age, String country) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
		this.country = country;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + ", lastname=" + lastname + ", age=" + age + ", country="
				+ country + "]";
	}
	
	
}
