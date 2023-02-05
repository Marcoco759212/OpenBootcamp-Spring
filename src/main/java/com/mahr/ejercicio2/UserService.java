package com.mahr.ejercicio2;

import org.springframework.stereotype.Component;

@Component
public class UserService {
	NotificationServices notification;
	
	public UserService(NotificationServices notification) {
		this.notification = notification;
	}
	
}
