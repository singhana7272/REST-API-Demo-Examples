package com.anamika.resource;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@RequestMapping(path = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Employee>> getAllEmployeesResource() {
		ArrayList<Employee> employees = employeeService.getAllEmployees();
		if (employees.isEmpty())
			return new ResponseEntity<ArrayList<Employee>>(employees, HttpStatus.NO_CONTENT);
		return new ResponseEntity<ArrayList<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping(path = "/employees/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmployeeByIdResource(@PathVariable("empId") int id) {
		Employee employee = null;
		try {
			employee = employeeService.searchEmployee(id);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (EmptyResultDataAccessException exception) {
			return new ResponseEntity<Employee>(employee, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> insertEmployeeResource(@RequestBody Employee employee) {
		Employee empl = employeeService.insertEmployee(employee);
		return new ResponseEntity<Employee>(empl, HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployeeResource(@PathVariable("id") int empId) {
		Employee emp = employeeService.deleteEmployee(empId);
		if (emp != null)
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		return new ResponseEntity<Employee>(emp, HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "/employees/{id}/{sal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployeeSalaryResource(@PathVariable("id") int empId,
			@PathVariable("sal") int salary) {
		Employee emp = employeeService.updateSalary(empId, salary);
		if (emp != null)
			return new ResponseEntity<Employee>(emp, HttpStatus.ACCEPTED);
		return new ResponseEntity<Employee>(emp, HttpStatus.NOT_MODIFIED);
	}

}
