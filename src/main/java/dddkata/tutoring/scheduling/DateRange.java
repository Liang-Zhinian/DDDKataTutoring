package dddkata.tutoring.scheduling;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by twer on 6/24/15.
 */
public class DateRange {
    private final String startDateString; // 2015.02.11
    private final String startTimeString; // e.g. 18:00
    private final String endTimeString; // e.g. 19:30
    private int times;
    private String dayOfWeek;

    public DateRange(String dayOfWeek, String startTimeString, String endTimeString, String startDateString, int times) {
        this.times = times;
        this.startDateString = startDateString;
        this.startTimeString = startTimeString;
        this.dayOfWeek = dayOfWeek;
        this.endTimeString = endTimeString;
    }

    public String getEndDateString() {
        DateTimeFormatter yyyyMMddHHmmFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        LocalDateTime firstStartTime = LocalDateTime.parse(this.startDateString + " " + this.startTimeString, yyyyMMddHHmmFormatter);
        LocalDateTime firstEndTime = LocalDateTime.parse(this.startDateString + " " + this.endTimeString, yyyyMMddHHmmFormatter);

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
        if (this.startTimeString.equals(dateRange.getStartTime()) && this.endTimeString.equals(dateRange.getEndTime())) {
            return true;
        }
        if (isThisEndTimeEarlyThanThatStartTime(dateRange) || isThisStartTimeLaterThanThatEndTime(dateRange)) {
            return false;
        }
        return true;
    }

    private boolean isDateOverlapped(DateRange dateRange) {
        if (this.startDateString.equals(dateRange.getStartDateString()) && isTheSameEndDate(dateRange)) {
            return true;
        }
        if (isThisEndDateEarlyThanThatStartDate(dateRange) || isThisStartDateLaterThanThatEndDate(dateRange)) {
            return false;
        }
        return true;
    }

    private boolean isThisStartDateLaterThanThatEndDate(DateRange dateRange) {
        return convertDateStringToLocalDateTime(this.startDateString).toInstant(ZoneOffset.of("+08:00"))
                .isAfter(dateRange.convertDateStringToLocalDateTime(dateRange.getEndDateString()).toInstant(ZoneOffset.of("+08:00")));
    }

    private boolean isThisEndDateEarlyThanThatStartDate(DateRange dateRange) {
        return convertDateStringToLocalDateTime(getEndDateString()).toInstant(ZoneOffset.of("+08:00"))
                .isBefore(dateRange.convertDateStringToLocalDateTime(dateRange.getStartDateString()).toInstant(ZoneOffset.of("+08:00")));
    }

    private LocalDateTime convertDateStringToLocalDateTime(String dateString) {
        DateTimeFormatter yyyyMMddHHmmFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return LocalDateTime.parse(dateString + " " + "00:00", yyyyMMddHHmmFormatter);
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

    public String getStartDateString() {
        return startDateString;
    }
}
