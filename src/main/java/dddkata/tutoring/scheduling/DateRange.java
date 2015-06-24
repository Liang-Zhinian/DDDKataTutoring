package dddkata.tutoring.scheduling;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Created by twer on 6/24/15.
 */
public class DateRange {
    private int times;

    public DateRange(String dayOfWeek, String startTime, String endTime, String startDate, int times) {
        this.times = times;
    }

    public String getEndDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDateTime startTime = LocalDateTime.of(2015, Month.FEBRUARY, 11, 18, 0);
        LocalDateTime endTime = startTime.plusWeeks(this.times - 1);
        String endDate = endTime.format(formatter);
        return endDate;
    }
}
