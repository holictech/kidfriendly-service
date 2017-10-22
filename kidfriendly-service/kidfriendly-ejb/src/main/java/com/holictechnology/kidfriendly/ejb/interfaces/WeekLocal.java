package com.holictechnology.kidfriendly.ejb.interfaces;


import java.util.List;

import javax.ejb.Local;

import com.holictechnology.kidfriendly.domain.dto.WeekDto;
import com.holictechnology.kidfriendly.domain.entity.Week;


@Local
public interface WeekLocal {

    /**
     * Method that lists every day of the week.
     * 
     * @return
     */
    List<Week> listAll();

    /**
     * Method that lists the days of the week with the schedules of the company
     * 
     * @param idCompany
     * @return
     */
    List<WeekDto> listByCompany(Long idCompany);
}
