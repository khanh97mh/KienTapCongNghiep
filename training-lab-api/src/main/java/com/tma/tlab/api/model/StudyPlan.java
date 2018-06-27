package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import com.tma.tlab.api.e.EnumQuestionChoice;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "study_plans")
@Entity
@Table(name = "study_plan")
public class StudyPlan implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "study_plan_id", unique = true, nullable = false)
	private Long studyPlanId;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;

	@Enumerated(EnumType.STRING)
	@Column(name = "completed", nullable = false, length = 1)
	private EnumQuestionChoice completed;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public StudyPlan() {
	}

	public Long getStudyPlanId() {
		return this.studyPlanId;
	}

	public void setStudyPlanId(Long studyPlanId) {
		this.studyPlanId = studyPlanId;
	}

	public EnumQuestionChoice getCompleted() {
		return this.completed;
	}

	public void setCompleted(EnumQuestionChoice completed) {
		this.completed = completed;
	}

}