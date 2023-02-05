package com.mahr.obspringdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String manufacturer;
	private String model;
	private String yearcoche;
	
	public Coche() {
		
	}
	
	public Coche(Long id, String manufacturer, String model, String yearcoche) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.yearcoche = yearcoche;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getYear() {
		return yearcoche;
	}
	
	public void setYear(String yearcoche) {
		this.yearcoche = yearcoche;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", year=" + yearcoche + "]";
	}
	
	
}
