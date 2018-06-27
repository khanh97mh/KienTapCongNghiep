package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "task_templates")
@Entity
@Table(name = "task_template")
public class TaskTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_template_id", unique = true, nullable = false)
	private Long taskTemplateId;

	@Column(name = "description", nullable = false, length = 255)
	private String description;

	@Column(name = "estimate", nullable = false)
	private float estimate;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "task_category_id")
	private TaskCategory taskCategory;

	public TaskTemplate() {
	}

	public Long getTaskTemplateId() {
		return this.taskTemplateId;
	}

	public void setTaskTemplateId(Long taskTemplateId) {
		this.taskTemplateId = taskTemplateId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getEstimate() {
		return this.estimate;
	}

	public void setEstimate(float estimate) {
		this.estimate = estimate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}