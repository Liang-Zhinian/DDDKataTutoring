package dddkata.tutoring.enrolment;

import java.util.HashMap;
import java.util.List;

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

    public void enrolAKidForACourse(String courseName, Enrolment enrolmentCourse) {
        this.courses.get(courseName).addKid(enrolmentCourse);
    }

    public Enrolment retrieveAKidForACourse(String courseName, String kidName) {
        Enrolment enrolment = this.courses.get(courseName).getEnrolmentsWithKidNames().get(kidName);
        return enrolment;
    }

    public void addCourse(String name, Course course) {
        this.courses.put(name, course);
    }

    public List<Enrolment> getAllEnrolmentForCourse(String courseName) {
        return this.courses.get(courseName).getEnrolments();
    }

    public void removeAKidFromACourse(String courseName, String kidName) {
        this.courses.get(courseName).removeEnrolment(kidName);
    }

    public Course getCourse(String courseName) {
        return this.courses.get(courseName);
    }
}
