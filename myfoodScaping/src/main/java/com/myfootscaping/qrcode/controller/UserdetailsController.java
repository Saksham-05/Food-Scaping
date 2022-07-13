package com.myfootscaping.qrcode.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.myfootscaping.qrcode.dao.Feedbackdto;
import com.myfootscaping.qrcode.dao.UserdetailsitemsDTO;
import com.myfootscaping.qrcode.entity.Product;
import com.myfootscaping.qrcode.entity.Userdetails;
import com.myfootscaping.qrcode.service.ProductService;
import com.myfootscaping.qrcode.service.UserdetailsService;

@RestController
public class UserdetailsController {

	@Autowired
	private UserdetailsService service;

	// RESTful API methods for Retrieval operations
	@GetMapping("/userdetails")
	public List<UserdetailsitemsDTO> list() {
		return service.listAll();
	}

	@GetMapping("/userdetails/{id}")
	public ResponseEntity<Userdetails> get(@PathVariable Integer id) {
		try {
			Userdetails product = service.get(id);
			return new ResponseEntity<Userdetails>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Userdetails>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Create operation
	@PostMapping("/userdetails")
	public ResponseEntity<?> add(@RequestBody UserdetailsitemsDTO product) {
		UserdetailsitemsDTO isinserted = service.save(product);
		
		ResponseObj obj = new ResponseObj();
		if (Objects.nonNull(isinserted.getUserid())) {
			
			obj = new ResponseObj("success", "Data inserted successfully");
			return new ResponseEntity<UserdetailsitemsDTO>(isinserted, HttpStatus.OK);
		} else {
			obj = new ResponseObj("failed", "Data failed to insert");
			return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/userfeedback")
	public ResponseEntity<?> userFeedback(@RequestParam(required = false) Integer userid, @RequestBody Feedbackdto feedbackdto) {
		
		boolean stat = service.saveUserFeedback(feedbackdto, userid);
		
		
		ResponseObj obj = new ResponseObj();
		if (stat) {
			
			obj = new ResponseObj("success", "Data inserted successfully");
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} else {
			obj = new ResponseObj("failed", "Data failed to insert");
			return new ResponseEntity<>(obj, HttpStatus.BAD_REQUEST);
		}

	}

	// RESTful API method for Update operation
	@PostMapping("/userdetails/{id}")
	public ResponseEntity<?> update(@RequestBody Userdetails product, @PathVariable Integer id) {
		System.out.println(product.toString() + " " + id);
		try {
			Userdetails existProduct = service.get(id);

			System.out.println(existProduct.toString());

//			service.save(existProduct);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// RESTful API method for Delete operation

	@DeleteMapping("/userdetails/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
}