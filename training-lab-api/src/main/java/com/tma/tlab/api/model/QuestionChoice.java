package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import com.tma.tlab.api.e.EnumQuestionChoice;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "question_choices")
@Entity
@Table(name = "question_choice")
public class QuestionChoice implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "choice_id", unique = true, nullable = false)
	private Long choiceId;

	@Enumerated(EnumType.STRING)
	@Column(name = "corrected", nullable = false, length = 1)
	private EnumQuestionChoice corrected;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "fill_in", length = 255)
	private String fillIn;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;

	public QuestionChoice() {
	}

	public Long getChoiceId() {
		return this.choiceId;
	}

	public void setChoiceId(Long choiceId) {
		this.choiceId = choiceId;
	}

	public EnumQuestionChoice getCorrected() {
		return this.corrected;
	}

	public void setCorrected(EnumQuestionChoice corrected) {
		this.corrected = corrected;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFillIn() {
		return this.fillIn;
	}

	public void setFillIn(String fillIn) {
		this.fillIn = fillIn;
	}

}