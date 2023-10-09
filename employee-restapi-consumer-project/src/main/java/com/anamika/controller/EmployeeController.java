package com.anamika.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.anamika.bean.Employee;
import com.anamika.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService; 

	@RequestMapping("/")
	public ModelAndView getMenu() {
		return new ModelAndView("menu");
	}
	
	@RequestMapping("/searchEmpPage")
	public ModelAndView searchEmpPageController() {
		return new ModelAndView("searchEmp");
	}
	
	@RequestMapping("/search")
	public ModelAndView searchEmployee(@RequestParam("empId") int empId) {
		
		Employee employee=null;
		try {
		employee=employeeService.getEmployeeById(empId);
		} 
		catch(Exception e) {}
		return new ModelAndView("employeeDetails","emp" ,employee );
		
	}
}
