package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "task_assignments")
@Entity
@Table(name = "task_assignment")
public class TaskAssignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_assignment_id", unique = true, nullable = false)
	private Long taskAssignmentId;

	@Column(name = "description", nullable = false, length = 255)
	private String description;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public TaskAssignment() {
	}

	public Long getTaskAssignmentId() {
		return this.taskAssignmentId;
	}

	public void setTaskAssignmentId(Long taskAssignmentId) {
		this.taskAssignmentId = taskAssignmentId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}