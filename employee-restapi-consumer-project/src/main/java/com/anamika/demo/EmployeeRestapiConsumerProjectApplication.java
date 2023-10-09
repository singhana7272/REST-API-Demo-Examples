package com.anamika.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.anamika.bean.Employee;

@SpringBootApplication(scanBasePackages = "com.anamika")
public class EmployeeRestapiConsumerProjectApplication /*implements CommandLineRunner*/{
	
	/*@Autowired
	private RestTemplate restTemplate;*/

	
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestapiConsumerProjectApplication.class, args);
	}
	
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}

	/*@Override
	public void run(String... args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter employee Id");
		int empId=scanner.nextInt();
		ResponseEntity<Employee> employee=restTemplate.getForEntity("http://localhost:8085/employees/"+empId, Employee.class);
		System.out.println(employee.getBody());
	}*/
	
	

}
