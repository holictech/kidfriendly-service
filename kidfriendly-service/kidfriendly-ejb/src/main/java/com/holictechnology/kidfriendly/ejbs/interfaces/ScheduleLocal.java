package com.holictechnology.kidfriendly.ejbs.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entitys.Schedule;

@Local
public interface ScheduleLocal {

	/**
	 * Method schedule
	 * @return
	 */
	List<Schedule> scheduleAll();
	
}