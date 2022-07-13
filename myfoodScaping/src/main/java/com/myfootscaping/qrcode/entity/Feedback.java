package com.myfootscaping.qrcode.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackid;
	private String feedbackmsg;


	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
	private Userdetails userdetail;

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(Integer feedbackid, String feedbackmsg, Userdetails userdetail) {
		super();
		this.feedbackid = feedbackid;
		this.feedbackmsg = feedbackmsg;
		this.userdetail = userdetail;
	}

	public Integer getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(Integer feedbackid) {
		this.feedbackid = feedbackid;
	}

	public String getFeedbackmsg() {
		return feedbackmsg;
	}

	public void setFeedbackmsg(String feedbackmsg) {
		this.feedbackmsg = feedbackmsg;
	}

	public Userdetails getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(Userdetails userdetail) {
		this.userdetail = userdetail;
	}
	


}
