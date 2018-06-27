package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

import java.util.Date;

@JsonApiResource(type = "user_tests")
@Entity
@Table(name = "user_test")
public class UserTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_test_id", unique = true, nullable = false)
	private String userTestId;

	@Column(name = "core")
	private int score;

	@Column(name = "test_date")
	private Date testDate;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "test_id")
	private Test test;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public UserTest() {
	}

	public String getUserTestId() {
		return this.userTestId;
	}

	public void setUserTestId(String userTestId) {
		this.userTestId = userTestId;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getTestDate() {
		return this.testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

}