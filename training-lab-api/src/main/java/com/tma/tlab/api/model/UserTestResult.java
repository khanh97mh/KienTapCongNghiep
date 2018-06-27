package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import com.tma.tlab.api.e.EnumQuestionChoice;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "user_test_results")
@Entity
@Table(name = "user_test_result")
public class UserTestResult implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_test_result_id", unique = true, nullable = false)
	private String userTestResultId;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "choice_id")
	private QuestionChoice questionChoise;

	@Enumerated(EnumType.STRING)
	@Column(name = "corrected", nullable = false, length = 1)
	private EnumQuestionChoice corrected;

	@Column(name = "fill_in", length = 255)
	private String fillIn;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "user_test_id")
	private UserTest userTest;

	public UserTestResult() {
	}

	public String getUserTestResultId() {
		return this.userTestResultId;
	}

	public void setUserTestResultId(String userTestResultId) {
		this.userTestResultId = userTestResultId;
	}

	public EnumQuestionChoice getCorrected() {
		return this.corrected;
	}

	public void setCorrected(EnumQuestionChoice corrected) {
		this.corrected = corrected;
	}

	public String getFillIn() {
		return this.fillIn;
	}

	public void setFillIn(String fillIn) {
		this.fillIn = fillIn;
	}

}