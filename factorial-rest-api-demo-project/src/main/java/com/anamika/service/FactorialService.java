package com.anamika.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {
	
	public int factorial(int n) {
		
		int fact=1;
		for(int i=1;i<=n;i++) {
			fact*=i;
		}
		
		return fact;
	}

}
