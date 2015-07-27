package dddkata.tutoring.enrolling.domain;

import dddkata.tutoring.scheduling.domain.Schedule;
import dddkata.tutoring.scheduling.domain.ScheduleRepository;

/**
 * Created by twer on 7/7/15.
 */
public class EnrollingTranslator {
    private Schedule scheduleInScheduling;

    private EnrollingTranslator() {
        ScheduleRepository scheduleRepositoryInScheduling = new ScheduleRepository();
        this.scheduleInScheduling = scheduleRepositoryInScheduling.retrieve();
    }

    public static EnrollingTranslator newInstance() {
        return new EnrollingTranslator();
    }

    public boolean areTwoCoursesOverlapped(Course thisCourse, Course thatCourse) {
        return scheduleInScheduling.isOverlapped(thisCourse.getName(), thatCourse.getName());
    }

    public boolean doesCourseExistInScheduling(String course) {
        return scheduleInScheduling.isCourseCreated(course);
    }
}
