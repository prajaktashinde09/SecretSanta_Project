package com.hof.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@Table
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ratingId;

	private String ratingName;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="rating")
	@JsonIgnore
	private List<Feedback> feedbacks;

	public Rating() {
	}

	public int getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public String getRatingName() {
		return this.ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setRating(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setRating(null);

		return feedback;
	}

}