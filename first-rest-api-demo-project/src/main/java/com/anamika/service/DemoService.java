package com.anamika.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
	
	public String getMessage() {
		return "<h1>Welcome to world of rest api!!</h1>";
	}
	
	public String greet(String name) {
		return "Welcome "+name;
	}

}
