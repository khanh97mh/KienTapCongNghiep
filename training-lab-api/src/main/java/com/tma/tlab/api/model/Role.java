package com.tma.tlab.api.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "roles")
@Entity
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@Column(name = "role_id", unique = true, nullable = false, length = 50)
	private String roleId;

	@JsonApiRelation
	@ManyToMany
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"), inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
	private Set<User> users = new HashSet<User>();

	@JsonApiRelation
	@ManyToMany
	@JoinTable(name = "roles_functions", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"), inverseJoinColumns = @JoinColumn(name = "function_id", referencedColumnName = "function_id"))
	private Set<Function> functions = new HashSet<Function>();

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	public Role() {
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}