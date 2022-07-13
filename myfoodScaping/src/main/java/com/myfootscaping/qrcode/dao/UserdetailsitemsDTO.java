package com.myfootscaping.qrcode.dao;

import java.util.ArrayList;
import java.util.List;

import com.myfootscaping.qrcode.entity.Fooditemqueries;

public class UserdetailsitemsDTO {
	
	private Integer userid;
	private String postalcode;
	private Integer containerid;
	private Boolean isfoodpicked;
	private List<Fooditemqueriesdto> fooditemqueries = new ArrayList();
	
	public UserdetailsitemsDTO() {
		
	}
	
	public UserdetailsitemsDTO(Integer userid, String postalcode, Integer containerid, Boolean isfoodpicked) {
		super();
		this.userid = userid;
		this.postalcode = postalcode;
		this.containerid = containerid;
		this.isfoodpicked = isfoodpicked;
	}
	
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
	public List<Fooditemqueriesdto> getFooditemqueries() {
		return fooditemqueries;
	}

	
	
	

}
