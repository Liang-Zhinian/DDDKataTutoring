package dddkata.tutoring.enrolment;

import dddkata.tutoring.scheduling.Schedule;
import dddkata.tutoring.scheduling.ScheduleRepository;

/**
 * Created by twer on 7/7/15.
 */
public class EnrolmentTranslator {
    private Schedule scheduleInScheduling;

    private EnrolmentTranslator() {
        ScheduleRepository scheduleRepositoryInScheduling = new ScheduleRepository();
        this.scheduleInScheduling = scheduleRepositoryInScheduling.retrieve();
    }

    public static EnrolmentTranslator newInstance() {
        return new EnrolmentTranslator();
    }

    public boolean areTwoCoursesOverlapped(Course thisCourse, Course thatCourse) {
        return scheduleInScheduling.isOverlapped(thisCourse.getName(), thatCourse.getName());
    }

    public boolean doesCourseExistInScheduling(String course) {
        return scheduleInScheduling.isCourseCreated(course);
    }
}
