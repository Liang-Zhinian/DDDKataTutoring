package dddkata.tutoring.sharedService;

import dddkata.tutoring.enrolment.Kid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by twer on 6/25/15.
 */
public class DataService {
    // TODO: Split the DataService into SchedulingDataService and EnrolmentDataService

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

    public void saveSchedulingCourse(String name, dddkata.tutoring.scheduling.Course course) {
        this.schedulingCourses.put(name, course);
    }

    public dddkata.tutoring.scheduling.Course retrieveSchedulingCourse(String name) {
        return this.schedulingCourses.get(name);
    }

    public void enrolAKidForACourse(String courseName, dddkata.tutoring.enrolment.Course enrolmentCourse) {
        this.enrolmentCourses.put(courseName, enrolmentCourse);
    }

    public Kid retrieveAKidForACourse(String courseName, String kidName) {
        Kid kid = this.enrolmentCourses.get(courseName).getKids().get(kidName);
        return kid;
    }

    public List<dddkata.tutoring.scheduling.Course> getAllSchedulingCourses() {
        return new ArrayList<>(this.schedulingCourses.values());
    }
}
