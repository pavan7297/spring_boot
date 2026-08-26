package com.ai.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ai.entity.Product;
import com.ai.utills.Generator;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/ecom")
@Slf4j
public class EcommersController{
	

	private Generator random ;
	
	@GetMapping("/allproducts")
	public ResponseEntity<?> getAllProducts() {
		try {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	@PostMapping("/saveData")
	public ResponseEntity<?> saveSingleProduct(@RequestBody Product product) {
		try {
			
			
			StringBuilder Checks = random.randomGenerator();
			System.out.println(Checks);
			
			
			return null;
		} catch (Exception e) {
			return null;
		}
	
	}
	
	

}
