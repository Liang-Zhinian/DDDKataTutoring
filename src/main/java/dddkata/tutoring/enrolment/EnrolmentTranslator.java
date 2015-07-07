package dddkata.tutoring.enrolment;

import dddkata.tutoring.scheduling.Schedule;

/**
 * Created by twer on 7/7/15.
 */
public class EnrolmentTranslator {
    private Schedule scheduleInScheduling;

    private EnrolmentTranslator() {

    }

    public static EnrolmentTranslator newInstance() {
        return new EnrolmentTranslator();
    }

    public void addScheduleInScheduling(Schedule scheduleInScheduling) {
        this.scheduleInScheduling = scheduleInScheduling;
    }

    public boolean areTwoCoursesOverlapped(Course thisCourse, Course thatCourse) {
        return scheduleInScheduling.isOverlapped(thisCourse.getName(), thatCourse.getName());
    }
}
