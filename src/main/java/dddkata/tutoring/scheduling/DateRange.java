package dddkata.tutoring.scheduling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by twer on 6/24/15.
 */
public class DateRange {
    private final String startDate; // 2015.02.11
    private final String startTime; // e.g. 18:00
    private final String endTime; // e.g. 19:30
    private int times;
    private String dayOfWeek;

    public DateRange(String dayOfWeek, String startTime, String endTime, String startDate, int times) {
        this.times = times;
        this.startDate = startDate;
        this.startTime = startTime;
        this.dayOfWeek = dayOfWeek;
        this.endTime = endTime;
    }

    public String getEndDateString() {
        DateTimeFormatter yyyyMMddHHmmFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        LocalDateTime firstStartTime = LocalDateTime.parse(this.startDate + " " + this.startTime, yyyyMMddHHmmFormatter);
        LocalDateTime firstEndTime = LocalDateTime.parse(this.startDate + " " + this.endTime, yyyyMMddHHmmFormatter);

        DateTimeFormatter yyyyMMddFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDateTime lastEndTime = firstStartTime.plusWeeks(this.times - 1).plusMinutes(ChronoUnit.MINUTES.between(firstStartTime, firstEndTime));
        String endDate = lastEndTime.format(yyyyMMddFormatter);
        return endDate;
    }

    public boolean conflictsWith(DateRange dateRange) {
        if (isTheSameDayOfWeek(dateRange.getDayOfWeek()) && isDateOverlapped(dateRange)
                && isTimeOverlapped(dateRange)) {
            return true;
        }
        return false;
    }

    private boolean isTimeOverlapped(DateRange dateRange) {
        if (this.startTime.equals(dateRange.getStartTime()) && this.endTime.equals(dateRange.getEndTime())) {
            return true;
        }
        if (isThisEndTimeEarlyThanThatStartTime(dateRange) || isThisStartTimeLaterThanThatEndTime(dateRange)) {
            return false;
        }
        return true;
    }

    private boolean isDateOverlapped(DateRange dateRange) {
        if (this.startDate.equals(dateRange.getStartDate()) && isTheSameEndDate(dateRange)) {
            return true;
        }
        if (isThisEndDateEarlyThanThatStartDate(dateRange) || isThisStartDateLaterThanThatEndDate(dateRange)) {
            return false;
        }
        return true;
    }

    private boolean isThisEndDateEarlyThanThatStartDate(DateRange dateRange) {
        return getEndDateTime(getEndDateString()).before(dateRange.getEndDateTime(dateRange.getEndDateString()));
    }

    private boolean isTheSameEndDate(DateRange dateRange) {
        return this.getEndDateString().equals(dateRange.getEndDateString());
    }

    private boolean isTheSameDayOfWeek(String dayOfWeek) {
        return this.dayOfWeek.equals(dayOfWeek);
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getStartDate() {
        return startDate;
    }
}
