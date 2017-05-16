package com.holictechnology.kidfriendly.domain.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the SCHEDULE database table.
 * 
 */
@Entity
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_SCHEDULE")
	private String idSchedule;

	@Column(name="`DS_ SCHEDULE`")
	private String ds_schedule;

	public Schedule() {
	}

	public String getIdSchedule() {
		return this.idSchedule;
	}

	public void setIdSchedule(String idSchedule) {
		this.idSchedule = idSchedule;
	}

	public String getDs_schedule() {
		return this.ds_schedule;
	}

	public void setDs_schedule(String ds_schedule) {
		this.ds_schedule = ds_schedule;
	}

}