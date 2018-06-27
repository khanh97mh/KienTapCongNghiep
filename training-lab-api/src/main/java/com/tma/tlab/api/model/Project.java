package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "projects")
@Entity
@Table(name = "project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id", unique = true, nullable = false)
	private Long projectId;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "delivery_center_id", nullable = false)
	private DeliveryCenter deliveryCenter;

	@Column(name = "description", nullable = false, length = 255)
	private String description;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	public Project() {
	}

	public Long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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