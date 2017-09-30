package com.holictechnology.kidfriendly.ejb;


import java.util.List;

import javax.ejb.Stateless;

import com.holictechnology.kidfriendly.domain.entity.Schedule;
import com.holictechnology.kidfriendly.ejb.interfaces.ScheduleLocal;


/**
 * Session Bean implementation class ScheduleEJB
 */
@Stateless
public class ScheduleEJB extends AbstractEJB implements ScheduleLocal {

    private static final long serialVersionUID = 4880059600951556747L;

    @Override
    public List<Schedule> listAll() {
        return entityManager.createQuery("SELECT schedule FROM Schedule AS schedule ORDER BY schedule.idSchedule ASC", Schedule.class).getResultList();
    }
}
