package com.holictechnology.kidfriendly.ejb;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.holictechnology.kidfriendly.domain.dto.ScheduleDto;
import com.holictechnology.kidfriendly.domain.dto.WeekDto;
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
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<Week> listAll() {
        return entityManager.createQuery("SELECT week FROM Week AS week ORDER BY week.idWeek ASC", Week.class).getResultList();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.holictechnology.kidfriendly.ejb.interfaces.WeekLocal#listByCompany(
     * java.lang.Long)
     */
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(value = TxType.NOT_SUPPORTED)
    public List<WeekDto> listByCompany(Long idCompany) {
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT week.ID_WEEK, week.DS_WEEK, scheduleInitial.DS_SCHEDULE AS INITIAL, scheduleFinish.DS_SCHEDULE AS FINISH ");
        sql.append("FROM WEEK AS week ");
        sql.append(
                "LEFT JOIN COMPANY_WEEK_SCHEDULE AS companyWeekSchedule ON (companyWeekSchedule.ID_WEEK = week.ID_WEEK AND companyWeekSchedule.ID_COMPANY = :idCompany) ");
        sql.append("LEFT JOIN SCHEDULE AS scheduleInitial ON (scheduleInitial.ID_SCHEDULE = companyWeekSchedule.ID_SCHEDULE_INITIAL) ");
        sql.append("LEFT JOIN SCHEDULE AS scheduleFinish ON (scheduleFinish.ID_SCHEDULE = companyWeekSchedule.ID_SCHEDULE_FINISH) ");
        sql.append("ORDER BY week.ID_WEEK");
        Query query = entityManager.createNativeQuery(sql.toString()).setParameter("idCompany", idCompany);
        Map<Long, WeekDto> map = new HashMap<Long, WeekDto>();
        List<WeekDto> weeks = new LinkedList<WeekDto>();
        Long idWeek = null;

        for (Object [] item : (List<Object []>) query.getResultList()) {
            idWeek = ((BigInteger) item[0]).longValue();

            if (!map.containsKey(idWeek)) {
                WeekDto weekDto = new WeekDto(idCompany, (String) item[1]);
                weeks.add(weekDto);
                map.put(idWeek, weekDto);
            }

            map.get(idWeek).addScheduleDto(new ScheduleDto((String) item[2], (String) item[3]));
        }

        return weeks;
    }
}
