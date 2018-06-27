package com.tma.tlab.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "functions")
@Entity
@Table(name="function")
public class Function implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonApiId
	@Id
	@Column(name="function_id", unique=true, nullable=false, length=50)
	private String functionId;

	@JsonApiRelation
	@ManyToMany
	@JoinTable(
	        name = "role_functions",
	        joinColumns = @JoinColumn(name = "function_id",referencedColumnName = "function_id"),
	        inverseJoinColumns = @JoinColumn( name = "role_id", referencedColumnName = "role_id" ) )	
	private Set<Role> roles = new HashSet<Role>();
	
	@Column(name = "name",nullable=false, length=100)
	private String name;

	public Function() {
	}

	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}