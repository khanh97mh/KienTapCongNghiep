package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "role_functions")
@Entity
@Table(name = "role_function")
public class RoleFunction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonApiId
	@Id
	@Column(name = "role_id")
	private String roleId;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "function_id")
	private Function function;

	public RoleFunction() {
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}