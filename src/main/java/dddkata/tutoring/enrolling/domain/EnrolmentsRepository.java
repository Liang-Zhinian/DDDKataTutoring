package dddkata.tutoring.enrolling.domain;

import dddkata.tutoring.enrolling.infrastructure.DataService;

/**
 * Created by twer on 7/27/15.
 */
public class EnrolmentsRepository {
    private DataService dataService = DataService.getInstance();

    public static EnrolmentsRepository newInstance() {
        return new EnrolmentsRepository();
    }

    public Enrolments retrieve() {
        return dataService.retrieveEnrolments();
    }

    public void save(Enrolments enrolmentsInEnrolment) {
        this.dataService.save(enrolmentsInEnrolment);
    }
}
