package com.holictechnology.kidfriendly.domain.dto;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class WeekDto implements Serializable {

    private static final long serialVersionUID = 3344515280774956326L;

    private Long idWeek;
    private String dsWeek;
    private List<ScheduleDto> schedules;

    public WeekDto() {}

    public WeekDto(Long idWeek, String dsWeek) {
        super();
        this.idWeek = idWeek;
        this.dsWeek = dsWeek;
    }

    public Long getIdWeek() {
        return idWeek;
    }

    public void setIdWeek(Long idWeek) {
        this.idWeek = idWeek;
    }

    public String getDsWeek() {
        return dsWeek;
    }

    public void setDsWeek(String dsWeek) {
        this.dsWeek = dsWeek;
    }

    public List<ScheduleDto> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDto> schedules) {
        this.schedules = schedules;
    }

    public void addScheduleDto(ScheduleDto scheduleDto) {
        if (schedules == null) {
            schedules = new LinkedList<ScheduleDto>();
        }

        schedules.add(scheduleDto);
    }
}
