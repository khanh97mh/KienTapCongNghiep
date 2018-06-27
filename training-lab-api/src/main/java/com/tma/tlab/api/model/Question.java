package com.tma.tlab.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tma.tlab.api.e.EnumQuestion;
import com.tma.tlab.api.e.EnumQuestionType;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "questions")
@Entity
@Table(name = "question")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "question_id", unique = true, nullable = false)
	private Long questionId;

	
	@JsonApiRelation
	@ManyToMany
	@JoinTable(name = "test_details", joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"), inverseJoinColumns = @JoinColumn(name = "test_id", referencedColumnName = "test_id"))
	private Set<Test> tests = new HashSet<>();

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;

	@Column(name = "description", nullable = false, length = 255)
	private String description;

	
	@Column(name = "question_type", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private EnumQuestionType questionType;

	@Column(name = "status", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private EnumQuestion status;

	public Question() {
	}

	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EnumQuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(EnumQuestionType questionType) {
		this.questionType = questionType;
	}

	public EnumQuestion getStatus() {
		return this.status;
	}

	public void setStatus(EnumQuestion status) {
		this.status = status;
	}

}