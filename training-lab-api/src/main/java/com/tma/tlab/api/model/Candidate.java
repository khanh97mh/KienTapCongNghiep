package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "candidates")
@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidate_id")
	private Long candidateId;

	@Column(name = "description")
	private String description;

	@Column(name = "email")
	private String email;

	@Column(name = "faculty")
	private String faculty;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "graduation_year")
	private String graduationYear;

	@Column(name = "phone")
	private String phone;

	@Column(name = "position")
	private String position;

	@Column(name = "university")
	private String university;

	public Long getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFaculty() {
		return this.faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGraduationYear() {
		return this.graduationYear;
	}

	public void setGraduationYear(String graduationYear) {
		this.graduationYear = graduationYear;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

}