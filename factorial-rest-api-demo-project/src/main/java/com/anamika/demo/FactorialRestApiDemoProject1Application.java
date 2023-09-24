package com.anamika.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.anamika")
public class FactorialRestApiDemoProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(FactorialRestApiDemoProject1Application.class, args);
	}

}
