package com.myfootscaping.qrcode.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfootscaping.qrcode.entity.Fooditems;
import com.myfootscaping.qrcode.entity.FooditemsRepo;



@Service
@Transactional
public class FooditemsService {
	
	 @Autowired
	    private FooditemsRepo repo;
	     
	    public List<Fooditems> listAll() {
	        return repo.findAll();
	    }
	     
	    public String save(Fooditems product) {
	        repo.save(product);
	        return "Data saved successfully";
	    }
	     
	    public Fooditems get(Integer id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }

}
