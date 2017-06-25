package com.holictechnology.kidfriendly.domain.dtos;

public class HourDateDto {

	private Long week;
	
	private Long hourInitial;
	
	private Long hourFinish;

	public Long getWeek() {
		return week;
	}

	public void setWeek(Long week) {
		this.week = week;
	}

	public Long getHourInitial() {
		return hourInitial;
	}

	public void setHourInitial(Long hourInitial) {
		this.hourInitial = hourInitial;
	}

	public Long getHourFinish() {
		return hourFinish;
	}

	public void setHourFinish(Long hourFinish) {
		this.hourFinish = hourFinish;
	}
	
}