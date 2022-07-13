package com.myfootscaping.qrcode.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fooditemqueries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fiqid;
	private String itemname;

	private Boolean eatnow;
	private Boolean takehome;
	private Boolean triedbefore;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	private Userdetails userdetails;

	public Integer getFiqid() {
		return fiqid;
	}

	public void setFiqid(Integer fiqid) {
		this.fiqid = fiqid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Boolean getEatnow() {
		return eatnow;
	}

	public void setEatnow(Boolean eatnow) {
		this.eatnow = eatnow;
	}

	public Boolean getTakehome() {
		return takehome;
	}

	public void setTakehome(Boolean takehome) {
		this.takehome = takehome;
	}

	public Boolean getTriedbefore() {
		return triedbefore;
	}

	public void setTriedbefore(Boolean triedbefore) {
		this.triedbefore = triedbefore;
	}

	public Userdetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(Userdetails userdetails) {
		this.userdetails = userdetails;
	}
	
	
	

}
