package com.hof.domain.dto;

public class FeedBackRating {
	String emailId;
	String name;
	Integer ratingId;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRatingId() {
		return ratingId;
	}
	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}
	@Override
	public String toString() {
		return "FeedBackRating [emailId=" + emailId + ", name=" + name + ", ratingId=" + ratingId + "]";
	}
	
	

}
