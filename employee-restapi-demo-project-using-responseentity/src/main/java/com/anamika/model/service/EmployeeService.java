package com.anamika.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.anamika.bean.Employee;

public interface EmployeeService {
	ArrayList<Employee> getAllEmployees();
	Employee searchEmployee(int empId);
	Employee insertEmployee(Employee employee);
	Employee deleteEmployee(int empId);
	Employee updateSalary(int empId,int salary);
}
