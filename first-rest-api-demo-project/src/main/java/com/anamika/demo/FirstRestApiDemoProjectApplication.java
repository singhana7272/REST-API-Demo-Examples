package com.anamika.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.anamika")
public class FirstRestApiDemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstRestApiDemoProjectApplication.class, args);
	}

}
