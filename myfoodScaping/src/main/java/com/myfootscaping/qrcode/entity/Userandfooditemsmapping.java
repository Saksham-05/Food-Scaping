package com.myfootscaping.qrcode.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Userandfooditemsmapping  {
	
	@Id
    Integer id;
	
	@ManyToOne
    @JoinColumn(name = "userid")
    private Userdetails userdetails;

    @ManyToOne
    @JoinColumn(name = "fooditemid")
    private Fooditems fooditems;

}
