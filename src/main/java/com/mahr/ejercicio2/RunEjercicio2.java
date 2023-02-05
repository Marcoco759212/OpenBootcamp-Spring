package com.mahr.ejercicio2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunEjercicio2 {
	public static void main(String[] args) {
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("//     Ejercicio 2 - Spring Context y notaciones @Component     ");
		System.out.println("////////////////////////////////////////////////////////////////");
		ApplicationContext context = new ClassPathXmlApplicationContext("beansEjercicio2.xml");
		
		UserService user = (UserService) context.getBean(UserService.class);
		
		user.notification.ImprimeSaludo();
	}
}
