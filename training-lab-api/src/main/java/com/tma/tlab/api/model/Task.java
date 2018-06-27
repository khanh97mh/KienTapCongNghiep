package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "tasks")
@Entity
@Table(name = "task")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id", unique = true, nullable = false)
	private Long taskId;

	@Column(name = "description", nullable = false, length = 45)
	private String description;

	public Task() {
	}

	public Long getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}