package com.anamika.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anamika.service.FactorialService;

@RestController
public class FactorialResource {
	
	@Autowired
	private FactorialService factorialService;
	
	@RequestMapping(path="/factorial/{num}",method=RequestMethod.GET,produces=MediaType.TEXT_PLAIN_VALUE)
	public String factorialResource(@PathVariable("num") int n) {
		return "Factorial ="+factorialService.factorial(n);
	}

}
