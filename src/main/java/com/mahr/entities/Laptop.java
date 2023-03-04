package com.mahr.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Laptop")
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private String caracteristicas;
	private Double precio;
	private boolean stock;
	
	public Laptop() {
		super();
	}

	public Laptop(Long id, String marca, String modelo, String caracteristicas, Double precio, boolean stock) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.caracteristicas = caracteristicas;
		this.precio = precio;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", caracteristicas=" + caracteristicas
				+ ", precio=" + precio + ", stock=" + stock + "]";
	}
}
