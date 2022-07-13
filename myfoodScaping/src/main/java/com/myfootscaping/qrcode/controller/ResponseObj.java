package com.myfootscaping.qrcode.controller;

public class ResponseObj {
	
	private String status;
	private String message;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseObj() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseObj(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
	
	

}
