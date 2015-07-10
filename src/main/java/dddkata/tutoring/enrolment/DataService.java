package dddkata.tutoring.enrolment;

import java.util.HashMap;

/**
 * Created by twer on 7/10/15.
 */
public class DataService {
    private static DataService singleton;
    private HashMap<String, Course> courses = new HashMap<>();

    private DataService() {
    }

    public static synchronized DataService getInstance() {
        if (singleton == null) {
            singleton = new DataService();
        }
        return singleton;
    }

    public void enrolAKidForACourse(String courseName, Course enrolmentCourse) {
        this.courses.put(courseName, enrolmentCourse);
    }

    public Enrolment retrieveAKidForACourse(String courseName, String kidName) {
        Enrolment enrolment = this.courses.get(courseName).getKids().get(kidName);
        return enrolment;
    }
}
