package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

import java.util.Date;

@JsonApiResource(type = "user_feedbacks")
@Entity
@Table(name = "user_feedback")
public class UserFeedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_feedback_id", unique = true, nullable = false)
	private String userFeedbackId;

	@Column(name = "description", length = 45)
	private String description;

	@Column(name = "feedback_date")
	private Date feedbackDate;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "feeder")
	private User user1;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user2;

	public UserFeedback() {
	}

	public String getUserFeedbackId() {
		return this.userFeedbackId;
	}

	public void setUserFeedbackId(String userFeedbackId) {
		this.userFeedbackId = userFeedbackId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFeedbackDate() {
		return this.feedbackDate;
	}

	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

}