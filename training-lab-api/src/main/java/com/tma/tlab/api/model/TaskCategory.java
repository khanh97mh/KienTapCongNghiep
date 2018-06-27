package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "task_categorys")
@Entity
@Table(name="task_category") 
public class TaskCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonApiId
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="task_category_id", unique=true, nullable=false)
	private Long taskCategoryId;

	@Column(name = "description", nullable=false, length=255)
	private String description;

	@Column(name = "name", nullable=false, length=45)
	private String name;

	public TaskCategory() {
	}

	public Long getTaskCategoryId() {
		return this.taskCategoryId;
	}

	public void setTaskCategoryId(Long taskCategoryId) {
		this.taskCategoryId = taskCategoryId;
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