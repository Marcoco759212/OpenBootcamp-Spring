package com.mahr.obspringdatajpa;

public class Figuras {
	String tipo = "Irregulares";
	
	public Figuras() {
		System.out.println("Clase Figuras");
	}
}

class FigurasIrregulares extends Figuras {
	
	int lados = 5;
	
	public FigurasIrregulares() {
		super();
		System.out.println(super.tipo);
	}
	
	public String detallesFigura() {
		return "la figura " + super.tipo + " tiene " + this.lados + " lados";
	}
	
}

class main{
	public static void main(String[] args) {
		FigurasIrregulares figurasIrregulares = new FigurasIrregulares();
		System.out.println(figurasIrregulares.detallesFigura());
	}
}