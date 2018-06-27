package com.tma.tlab.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "tests")
@Entity
@Table(name = "test")
@NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "test_id", unique = true, nullable = false)
	private Long testId;

	@JsonApiRelation
	@ManyToMany
	@JoinTable(name = "test_details", joinColumns = @JoinColumn(name = "test_id", referencedColumnName = "test_id"), inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "question_id"))
	private Set<Question> questions = new HashSet<>();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@Column(name = "description", nullable = false, length = 45)
	private String description;

	@Column(name = "level", nullable = false)
	private Long level;

	public Test() {
	}

	public Long getTestId() {
		return this.testId;
	}

	public void setTestId(Long testId) {
		this.testId = testId;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getLevel() {
		return this.level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

}