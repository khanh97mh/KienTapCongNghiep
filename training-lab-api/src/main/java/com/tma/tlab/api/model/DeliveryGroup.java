package com.tma.tlab.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "delivery_groups")
@Entity
@Table(name = "delivery_group")
public class DeliveryGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "delivery_group_id")
	private Long deliveryGroupId;

	@Column(name = "description")
	private String description;

	@Column(name = "name", nullable = false, length = 45)
	private String name;

	public DeliveryGroup() {
	}

	public Long getDeliveryGroupId() {
		return this.deliveryGroupId;
	}

	public void setDeliveryGroupId(Long deliveryGroupId) {
		this.deliveryGroupId = deliveryGroupId;
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