package com.tma.tlab.api.model;

import java.io.Serializable;
import javax.persistence.*;

import com.tma.tlab.api.e.EnumQuestionChoice;

import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiRelation;
import io.katharsis.resource.annotations.JsonApiResource;

@JsonApiResource(type = "schedules")
@Entity
@Table(name = "schedule")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonApiId
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "schedule_id", unique = true, nullable = false)
	private Long scheduleId;

	@Enumerated(EnumType.STRING)
	@Column(name = "fri_a", length = 1)
	private EnumQuestionChoice friA;

	@Enumerated(EnumType.STRING)
	@Column(name = "fri_m", length = 1)
	private EnumQuestionChoice friM;

	@Enumerated(EnumType.STRING)
	@Column(name = "mon_a", length = 1)
	private EnumQuestionChoice monA;

	@Enumerated(EnumType.STRING)
	@Column(name = "mon_m", length = 1)
	private EnumQuestionChoice monM;

	@Enumerated(EnumType.STRING)
	@Column(name = "thu_a", length = 1)
	private EnumQuestionChoice thuA;

	@Enumerated(EnumType.STRING)
	@Column(name = "thu_m", length = 1)
	private EnumQuestionChoice thuM;

	@Enumerated(EnumType.STRING)
	@Column(name = "tue_a", length = 1)
	private EnumQuestionChoice tueA;

	@Enumerated(EnumType.STRING)
	@Column(name = "tue_m", length = 1)
	private EnumQuestionChoice tueM;

	@Enumerated(EnumType.STRING)
	@Column(name = "wed_a", length = 1)
	private EnumQuestionChoice wedA;

	@Enumerated(EnumType.STRING)
	@Column(name = "wed_m", length = 1)
	private EnumQuestionChoice wedM;

	@Column(name = "week_id", length = 20)
	private String weekId;

	@JsonApiRelation
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Schedule() {
	}

	public Long getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public EnumQuestionChoice getFriA() {
		return this.friA;
	}

	public void setFriA(EnumQuestionChoice friA) {
		this.friA = friA;
	}

	public EnumQuestionChoice getFriM() {
		return this.friM;
	}

	public void setFriM(EnumQuestionChoice friM) {
		this.friM = friM;
	}

	public EnumQuestionChoice getMonA() {
		return this.monA;
	}

	public void setMonA(EnumQuestionChoice monA) {
		this.monA = monA;
	}

	public EnumQuestionChoice getMonM() {
		return this.monM;
	}

	public void setMonM(EnumQuestionChoice monM) {
		this.monM = monM;
	}

	public EnumQuestionChoice getThuA() {
		return this.thuA;
	}

	public void setThuA(EnumQuestionChoice thuA) {
		this.thuA = thuA;
	}

	public EnumQuestionChoice getThuM() {
		return this.thuM;
	}

	public void setThuM(EnumQuestionChoice thuM) {
		this.thuM = thuM;
	}

	public EnumQuestionChoice getTueA() {
		return this.tueA;
	}

	public void setTueA(EnumQuestionChoice tueA) {
		this.tueA = tueA;
	}

	public EnumQuestionChoice getTueM() {
		return this.tueM;
	}

	public void setTueM(EnumQuestionChoice tueM) {
		this.tueM = tueM;
	}

	public EnumQuestionChoice getWedA() {
		return this.wedA;
	}

	public void setWedA(EnumQuestionChoice wedA) {
		this.wedA = wedA;
	}

	public EnumQuestionChoice getWedM() {
		return this.wedM;
	}

	public void setWedM(EnumQuestionChoice wedM) {
		this.wedM = wedM;
	}

	public String getWeekId() {
		return this.weekId;
	}

	public void setWeekId(String weekId) {
		this.weekId = weekId;
	}

}