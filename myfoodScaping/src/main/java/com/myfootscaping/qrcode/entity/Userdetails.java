package com.myfootscaping.qrcode.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

@Entity
public class Userdetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;

	private String postalcode;
	private Integer containerid;
	private Boolean isfoodpicked;

	@OneToMany(mappedBy = "userdetails", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Fooditemqueries> fooditemqueries = new ArrayList();


	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public Integer getContainerid() {
		return containerid;
	}

	public void setContainerid(Integer containerid) {
		this.containerid = containerid;
	}

	public Boolean getIsfoodpicked() {
		return isfoodpicked;
	}

	public void setIsfoodpicked(Boolean isfoodpicked) {
		this.isfoodpicked = isfoodpicked;
	}

	public List<Fooditemqueries> getFooditemqueries() {
		return fooditemqueries;
	}

	@Override
	public String toString() {
		return "Userdetails [userid=" + userid + ", postalcode=" + postalcode + ", containerid=" + containerid
				+ ", isfoodpicked=" + isfoodpicked + ", fooditemqueries=" + fooditemqueries + "]";
	}

}
