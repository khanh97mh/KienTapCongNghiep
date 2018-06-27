package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "user_mentors")
@Entity
@Table(name = "user_mentor")
public class UserMentor implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_mentor_id", unique = true, nullable = false)
	private String userMentorId;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "mentor_id")
	private User mentor;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public UserMentor() {
	}

	public String getUserMentorId() {
		return this.userMentorId;
	}

	public void setUserMentorId(String userMentorId) {
		this.userMentorId = userMentorId;
	}

}