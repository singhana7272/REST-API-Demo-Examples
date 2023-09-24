package com.anamika.model.persistence;

import java.sql.SQLException;
import java.util.ArrayList;

import com.anamika.bean.Employee;

public interface EmployeeDao {
	ArrayList<Employee> getAllRecords();
	Employee searchRecord(int empId);
	boolean insertData(Employee employee);
	boolean deleteData(int empId);
	boolean updateSalary(int empId,int empSalary);
}
