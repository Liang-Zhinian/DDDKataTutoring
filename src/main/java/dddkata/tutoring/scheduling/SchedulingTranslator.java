package dddkata.tutoring.scheduling;

import dddkata.tutoring.enrolling.Enrolments;
import dddkata.tutoring.enrolling.EnrolmentsRepository;

/**
 * Created by twer on 7/27/15.
 */
public class SchedulingTranslator {
    public static SchedulingTranslator newInstance() {
        return new SchedulingTranslator();
    }

    public boolean haveKidsEnrolledCourse(String courseName) {
        EnrolmentsRepository enrolmentsRepository = EnrolmentsRepository.newInstance();
        Enrolments enrolments = enrolmentsRepository.retrieve();
        return enrolments.haveKidsEnrolledCourse(courseName);
    }
}
