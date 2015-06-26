package dddkata.tutoring.sharedService;

import dddkata.tutoring.enrolment.Kid;
import dddkata.tutoring.scheduling.Course;

import java.util.HashMap;

/**
 * Created by twer on 6/25/15.
 */
public class DataService {
    private static DataService singleton;
    private HashMap<String, dddkata.tutoring.scheduling.Course> schedulingCourses = new HashMap<>();
    private HashMap<String, dddkata.tutoring.enrolment.Course> enrolmentCourses = new HashMap<>();

    private DataService() {
    }

    public static synchronized DataService getInstance() {
        if (singleton == null) {
            singleton = new DataService();
        }
        return singleton;
    }

    public void saveSchedulingCourse(String name, Course course) {
        this.schedulingCourses.put(name, course);
    }

    public Course retrieveSchedulingCourse(String name) {
        return this.schedulingCourses.get(name);
    }

    public void enrolAKidForACourse(String courseName, dddkata.tutoring.enrolment.Course enrolmentCourse) {
        this.enrolmentCourses.put(courseName, enrolmentCourse);
    }

    public Kid retrieveAKidForACourse(String courseName, String kidName) {
        Kid kid = this.enrolmentCourses.get(courseName).getKids().get(kidName);
        return kid;
    }
}
