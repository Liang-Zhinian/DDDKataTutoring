package dddkata.tutoring.scheduling;

/**
 * Created by twer on 7/27/15.
 */
public class ScheduleRepository {
    private DataService dataService = DataService.getInstance();

    public Schedule retrieve() {
        return dataService.retrieveSchedule();
    }

    public static ScheduleRepository newInstance() {
        return new ScheduleRepository();
    }

    public void save(Schedule scheduleInScheduling) {
        dataService.saveSchedule(scheduleInScheduling);
    }
}
