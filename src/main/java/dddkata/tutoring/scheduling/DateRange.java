package dddkata.tutoring.scheduling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by twer on 6/24/15.
 */
public class DateRange {
    private final String startDate; // 2015.02.11
    private final String startTime; // 18
    private int times;

    public DateRange(String dayOfWeek, String startTime, String endTime, String startDate, int times) {
        this.times = times;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public String getEndDate() {
        DateTimeFormatter startTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(this.startDate + " " + this.startTime, startTimeFormatter);

        DateTimeFormatter endTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDateTime endTime = startTime.plusWeeks(this.times - 1);
        String endDate = endTime.format(endTimeFormatter);
        return endDate;
    }
}
