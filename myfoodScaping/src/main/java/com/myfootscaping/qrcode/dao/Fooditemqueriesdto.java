package com.myfootscaping.qrcode.dao;

public class Fooditemqueriesdto {
	
	private Integer fiqid;
	private String itemname;

	private Boolean eatnow;
	private Boolean takehome;
	private Boolean triedbefore;
	
	
	public Fooditemqueriesdto(String itemname, Boolean eatnow, Boolean takehome, Boolean triedbefore) {
		super();
		this.fiqid = fiqid;
		this.itemname = itemname;
		this.eatnow = eatnow;
		this.takehome = takehome;
		this.triedbefore = triedbefore;
	}
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
	
	

}
