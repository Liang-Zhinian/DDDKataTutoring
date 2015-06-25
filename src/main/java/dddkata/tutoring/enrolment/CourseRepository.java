package dddkata.tutoring.enrolment;

import dddkata.tutoring.sharedService.DataService;

/**
 * Created by twer on 6/25/15.
 */
public class CourseRepository {

    private DataService dataService = DataService.getInstance();

    private CourseRepository() {

    }

    public void enrolAKidForACourse(String courseName, String kidName, Kid kid) {
        dataService.enrolAKidForACourse(courseName, kidName, kid);
    }

    public static CourseRepository newInstance() {
        return new CourseRepository();
    }
}
