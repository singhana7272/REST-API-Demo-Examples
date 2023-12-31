package com.anamika.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anamika.bean.Employee;
import com.anamika.model.service.EmployeeService;

@RestController
public class EmployeeResource {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(path="/employees",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Employee> getAllEmployeesResource(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(path="/employees/{empId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeByIdResource(@PathVariable("empId") int id) {
		return employeeService.searchEmployee(id);
	}
	
	@PostMapping(path="/employees",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employee insertEmployeeResource(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}
	
	
	@DeleteMapping(path="/employees/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee deleteEmployeeResource(@PathVariable("id") int empId) {
		return employeeService.deleteEmployee(empId);
	}
	
	@PutMapping(path="/employees/{id}/{sal}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployeeSalaryResource(@PathVariable("id") int empId,@PathVariable("sal") int salary) {
		return employeeService.updateSalary(empId, salary);
	}
	

}
