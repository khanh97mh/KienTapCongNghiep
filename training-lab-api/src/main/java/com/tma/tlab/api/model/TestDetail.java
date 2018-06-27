package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "test_details")
@Entity
@Table(name = "test_detail")
public class TestDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@Column(name = "test_id")
	private String testId;

	@Column(name = "question_id")
	private String questionId;

	public String getTestId() {
		return this.testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

}