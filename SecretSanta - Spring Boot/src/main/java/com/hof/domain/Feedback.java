package com.hof.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the feedback database table.
 * 
 */
@Entity
@Table
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedbackId;

	@Temporal(TemporalType.DATE)
	private Date createdDate;

	private String emailId;

	private String name;

	//bi-directional many-to-one association to Rating
	@ManyToOne
	@JoinColumn(name="RatingId")
	private Rating rating;

	public Feedback() {
	}

	public int getFeedbackId() {
		return this.feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rating getRating() {
		return this.rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

}