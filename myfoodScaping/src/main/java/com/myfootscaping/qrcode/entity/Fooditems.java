package com.myfootscaping.qrcode.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Fooditems {
	private Integer fooditemid;
	private String name;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getFooditemid() {
		return fooditemid;
	}




	public void setFooditemid(Integer fooditemid) {
		this.fooditemid = fooditemid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "fooditems")
    public Set<Userandfooditemsmapping> userandfooditemsmappings;
	
//	@ManyToMany(targetEntity=Userdetails.class, mappedBy = "fooditems")
//	List<Userdetails> userdetails;
//
//
//	public List<Userdetails> getUserdetails() {
//		return userdetails;
//	}
//
//
//	public void setUserdetails(List<Userdetails> userdetails) {
//		this.userdetails = userdetails;
//	}


	@Override
	public String toString() {
		return "Fooditems [id=" + fooditemid + ", name=" + name + "]";
	}
	
	

}
