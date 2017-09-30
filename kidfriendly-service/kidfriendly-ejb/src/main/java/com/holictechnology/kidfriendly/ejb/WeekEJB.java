package com.holictechnology.kidfriendly.ejb;


import java.util.List;

import javax.ejb.Stateless;

import com.holictechnology.kidfriendly.domain.entity.Week;
import com.holictechnology.kidfriendly.ejb.interfaces.WeekLocal;


@Stateless
public class WeekEJB extends AbstractEJB implements WeekLocal {

    private static final long serialVersionUID = 489640806734868387L;

    /*
     * (non-Javadoc)
     * 
     * @see com.holictechnology.kidfriendly.ejb.interfaces.WeekLocal#listAll()
     */
    @Override
    public List<Week> listAll() {
        return entityManager.createQuery("SELECT week FROM Week AS week ORDER BY week.idWeek ASC", Week.class).getResultList();
    }
}
