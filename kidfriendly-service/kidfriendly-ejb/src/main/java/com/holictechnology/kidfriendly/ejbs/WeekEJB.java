package com.holictechnology.kidfriendly.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.holictechnology.kidfriendly.domain.entitys.Week;
import com.holictechnology.kidfriendly.ejbs.interfaces.WeekEJBLocal;

/**
 * Session Bean implementation class WeekEJB
 */
@Stateless
public class WeekEJB extends AbstractEJB implements WeekEJBLocal {

    /**
	 * 
	 */
	private static final long serialVersionUID = 489640806734868387L;

	/**
     * Default constructor. 
     */
    public WeekEJB() {
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Week> weekAll() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT w FROM Week w ORDER BY w.idWeek asc ");
		
		Query query = entityManager.createQuery(sql.toString());
		
		return query.getResultList();
	}

}
