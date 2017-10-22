package com.holictechnology.kidfriendly.domain.dto;


import java.io.Serializable;


public class ScheduleDto implements Serializable {

    private static final long serialVersionUID = -7290353889301268463L;

    private String scheduleInitial;
    private String scheduleFinish;

    public ScheduleDto() {}

    public ScheduleDto(String scheduleInitial, String scheduleFinish) {
        super();
        this.scheduleInitial = scheduleInitial;
        this.scheduleFinish = scheduleFinish;
    }

    public String getScheduleInitial() {
        return scheduleInitial;
    }

    public void setScheduleInitial(String scheduleInitial) {
        this.scheduleInitial = scheduleInitial;
    }

    public String getScheduleFinish() {
        return scheduleFinish;
    }

    public void setScheduleFinish(String scheduleFinish) {
        this.scheduleFinish = scheduleFinish;
    }

}
