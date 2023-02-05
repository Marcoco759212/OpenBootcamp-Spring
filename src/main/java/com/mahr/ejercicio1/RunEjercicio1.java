package com.mahr.ejercicio1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunEjercicio1 {
	public static void main(String[] args) {
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("//                   Ejercicio 1 - Spring Context               ");
		System.out.println("////////////////////////////////////////////////////////////////");
		ApplicationContext context = new ClassPathXmlApplicationContext("beansEjercicio1.xml");

		Saludo saludo = (Saludo) context.getBean(Saludo.class);
		
		saludo.ImprimeSaludo();
	}
}
