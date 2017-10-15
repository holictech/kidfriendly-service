package com.holictechnology.kidfriendly.library.utilites;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class DateUtilities implements Serializable {

    private static final long serialVersionUID = 2664353472659080507L;

    private DateUtilities() {}

    /**
     * Method that subtracts years from the current date
     * 
     * @param years
     * @param pattern
     * @return
     */
    public static String subtractYear(long years, String pattern) {
        if (years > 0 || ObjectUtilities.isEmptyOrNull(pattern)) {
            throw new IllegalArgumentException();
        }

        return addSubtract(years, ChronoUnit.YEARS, pattern);
    }

    /**
     * Method that subtracts years from the current date
     * 
     * @param years
     * @param pattern
     * @return
     */
    public static String addYear(long years, String pattern) {
        if (years < 0 || ObjectUtilities.isEmptyOrNull(pattern)) {
            throw new IllegalArgumentException();
        }

        return addSubtract(years, ChronoUnit.YEARS, pattern);
    }

    /**
     * Method that gets the day of the week.
     * 
     * @return
     */
    public static int getDayOfWeek() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);

        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * @param amountToAddSubtract
     * @param temporalUnit
     * @param pattern
     * @return
     */
    private static String addSubtract(long amountToAddSubtract, TemporalUnit temporalUnit, String pattern) {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plus(amountToAddSubtract, temporalUnit);

        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }
}
