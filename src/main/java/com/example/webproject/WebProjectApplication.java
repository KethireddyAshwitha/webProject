package com.example.webproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class WebProjectApplication {

	public static void main(String[] args) {
		System.out.println("running");
		SpringApplication.run(WebProjectApplication.class, args);
		System.out.println("executing");
	}

}
