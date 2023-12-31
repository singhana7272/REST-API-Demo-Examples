package com.anamika.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.anamika.bean.Employee;
import com.anamika.model.persistence.EmployeeDao;
import com.anamika.model.persistence.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
	private EmployeeDao employeeDao;

	@Override
	public ArrayList<Employee> getAllEmployees(){
		return employeeDao.getAllRecords();
	}

	@Override
	public Employee searchEmployee(int empId) {
		return employeeDao.searchRecord(empId);
	}

	@Override
	public Employee insertEmployee(Employee employee) {
		if(employeeDao.insertData(employee))
			return employee;
		return null;
	}

	@Override
	public Employee deleteEmployee(int empId) {
		Employee employee=employeeDao.searchRecord(empId);
		if(employeeDao.deleteData(empId))
			return employee;
		return null;
	}

	@Override
	public Employee updateSalary(int empId, int salary) {
		Employee employee=employeeDao.searchRecord(empId);
		if(employeeDao.updateSalary(empId, salary))
			return employee;
		return null;
	}

}
