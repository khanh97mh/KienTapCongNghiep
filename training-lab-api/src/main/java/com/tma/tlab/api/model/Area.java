package com.tma.tlab.api.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "areas")
@Entity
@Table(name = "area")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "area_id")
	private Long areaId;

	@Basic
	@Column(name = "description", nullable = false, insertable = true, updatable = true, length = 45)
	private String description;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	public Long getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}