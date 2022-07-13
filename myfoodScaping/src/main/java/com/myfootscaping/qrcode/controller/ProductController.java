package com.myfootscaping.qrcode.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.myfootscaping.qrcode.entity.Product;
import com.myfootscaping.qrcode.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/products")
	public List<Product> list() {
		return service.listAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id) {
		try {
			Product product = service.get(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation

	@PostMapping("/products")
	public void add(@RequestBody Product product) {
		
		service.save(product);
	}

	// RESTful API method for Update operation
	@PostMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		System.out.println(product.toString()+" "+id);
		try {
			Product existProduct = service.get(id);
			
			System.out.println(existProduct.toString());
			existProduct.setName(product.getName());
			existProduct.setPrice(product.getPrice());
			
			service.save(existProduct);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation

	@DeleteMapping("/products/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
}