package dddkata.tutoring.sharedService;

import dddkata.tutoring.enrolment.Kid;
import dddkata.tutoring.scheduling.Course;

import java.util.HashMap;

/**
 * Created by twer on 6/25/15.
 */
public class DataService {
    private static DataService singleton;
    private HashMap<String, Course> schedulingCourses = new HashMap<>();

    private DataService() {
    }

    public static DataService getInstance() {
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

    public void enrolAKidForACourse(String courseName, String kidName, Kid kid) {
        if (!this.enrolmentCourses.containsKey(courseName)) {
            this.enrolmentCourses.put(courseName
                    , dddkata.tutoring.sharedService.Course.newInstance(courseName));
        }
        dddkata.tutoring.sharedService.Course course = this.enrolmentCourses.get(courseName);
        HashMap<String, Kid> kids = course.getKids();
        if (!kids.containsKey(kidName)) {
            kids.put(kidName, kid);
        }
    }
}
