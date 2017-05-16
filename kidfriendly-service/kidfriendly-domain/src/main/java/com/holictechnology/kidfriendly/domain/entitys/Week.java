package com.holictechnology.kidfriendly.domain.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the WEEK database table.
 * 
 */
@Entity
@NamedQuery(name="Week.findAll", query="SELECT w FROM Week w")
public class Week implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_WEEK")
	private String idWeek;

	@Column(name="DS_WEEK")
	private String dsWeek;

	public Week() {
	}

	public String getIdWeek() {
		return this.idWeek;
	}

	public void setIdWeek(String idWeek) {
		this.idWeek = idWeek;
	}

	public String getDsWeek() {
		return this.dsWeek;
	}

	public void setDsWeek(String dsWeek) {
		this.dsWeek = dsWeek;
	}

}