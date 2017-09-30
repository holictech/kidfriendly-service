package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.entity.Schedule;


@Local
public interface ScheduleLocal {

    /**
     * Method that lists all schedules.
     * 
     * @return
     */
    List<Schedule> listAll();
}
