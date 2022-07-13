package com.myfootscaping.qrcode.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.myfootscaping.qrcode.entity.Fooditems;
import com.myfootscaping.qrcode.service.FooditemsService;

@RestController
public class Fooditemscontroller {

	@Autowired
	private FooditemsService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/fooditems")
	public List<Fooditems> list() {
		return service.listAll();
	}

	@GetMapping("/fooditems/{id}")
	public ResponseEntity<Fooditems> get(@PathVariable Integer id) {
		try {
			Fooditems product = service.get(id);
			return new ResponseEntity<Fooditems>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Fooditems>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation

	@PostMapping("/fooditems")
	public void add(@RequestBody Fooditems product) {
		
		service.save(product);
	}

	// RESTful API method for Update operation
	@PostMapping("/fooditems/{id}")
	public ResponseEntity<?> update(@RequestBody Fooditems product, @PathVariable Integer id) {
		System.out.println(product.toString()+" "+id);
		try {
			Fooditems existProduct = service.get(id);
			
			System.out.println(existProduct.toString());
			existProduct.setName(product.getName());
			
			service.save(existProduct);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation

	@DeleteMapping("/fooditems/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}