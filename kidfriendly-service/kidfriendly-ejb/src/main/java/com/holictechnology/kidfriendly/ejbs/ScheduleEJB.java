package com.holictechnology.kidfriendly.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.holictechnology.kidfriendly.domain.entitys.Schedule;
import com.holictechnology.kidfriendly.ejbs.interfaces.ScheduleLocal;

/**
 * Session Bean implementation class ScheduleEJB
 */
@Stateless
public class ScheduleEJB extends AbstractEJB implements ScheduleLocal {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4880059600951556747L;

	/**
     * Default constructor. 
     */
    public ScheduleEJB() {
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Schedule> scheduleAll() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT s FROM Schedule s ORDER BY s.idSchedule asc ");
		
		Query query = entityManager.createQuery(sql.toString());
		
		return query.getResultList();
	}

}