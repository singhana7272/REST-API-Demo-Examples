package com.anamika.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anamika.bean.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Employee getEmployeeById(int empId) {
		return restTemplate.getForObject("http://localhost:8085/employees/"+empId, Employee.class);
		
	}

}
