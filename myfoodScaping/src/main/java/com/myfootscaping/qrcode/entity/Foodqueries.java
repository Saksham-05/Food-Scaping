package com.myfootscaping.qrcode.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foodqueries {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer foodqueryid;
	private Boolean eatnow;
	private Boolean takehome;
	private Boolean triedbefore;

	public Integer getFoodqueryid() {
		return foodqueryid;
	}

	public void setFoodqueryid(Integer foodqueryid) {
		this.foodqueryid = foodqueryid;
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

	@Override
	public String toString() {
		return "Foodqueries [foodqueryid=" + foodqueryid + ", eatnow=" + eatnow + ", takehome=" + takehome
				+ ", triedbefore=" + triedbefore + "]";
	}

}
