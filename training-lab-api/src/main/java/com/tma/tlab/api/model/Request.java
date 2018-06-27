package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

import java.util.Date;

@JsonApiResource(type = "requests")
@Entity
@Table(name = "request")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "request_id", unique = true, nullable = false)
	private Long requestId;

	@Column(name = "description", nullable = false, length = 45)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	private Date dueDate;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "request_date")
	private Date requestDate;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	public Request() {
	}

	public Long getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

}