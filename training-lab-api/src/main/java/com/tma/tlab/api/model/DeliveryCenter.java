package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "delivery_centers")
@Entity
@Table(name = "delivery_center")
public class DeliveryCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "delivery_center_id")
	private Long deliveryCenterId;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "delivery_group_id")
	private DeliveryGroup deliveryGroup;

	@Column(name = "description")
	private String description;

	@Column(name = "name")
	private String name;

	public DeliveryCenter() {
	}

	public Long getDeliveryCenterId() {
		return this.deliveryCenterId;
	}

	public void setDeliveryCenterId(Long deliveryCenterId) {
		this.deliveryCenterId = deliveryCenterId;
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