package com.holictechnology.kidfriendly.domain.entitys;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WEEK_SCHEDULE_COMPANY database table.
 * 
 */
@Entity
@Table(name="WEEK_SCHEDULE_COMPANY")
@NamedQuery(name="WeekScheduleCompany.findAll", query="SELECT w FROM WeekScheduleCompany w")
public class WeekScheduleCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_WEEK_SCHEDULE_COMPANY")
	private String idWeekScheduleCompany;

	@Column(name="ID_COMPANY")
	private java.math.BigInteger idCompany;

	//bi-directional many-to-one association to Schedule
	@ManyToOne
	@JoinColumn(name="ID_SCHEDULE")
	private Schedule schedule;

	//bi-directional many-to-one association to Week
	@ManyToOne
	@JoinColumn(name="ID_WEEK")
	private Week week;

	public WeekScheduleCompany() {
	}

	public String getIdWeekScheduleCompany() {
		return this.idWeekScheduleCompany;
	}

	public void setIdWeekScheduleCompany(String idWeekScheduleCompany) {
		this.idWeekScheduleCompany = idWeekScheduleCompany;
	}

	public java.math.BigInteger getIdCompany() {
		return this.idCompany;
	}

	public void setIdCompany(java.math.BigInteger idCompany) {
		this.idCompany = idCompany;
	}

	public Schedule getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public Week getWeek() {
		return this.week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}

}