package dddkata.tutoring.sharedService;

import dddkata.tutoring.scheduling.Course;

import java.util.HashMap;

/**
 * Created by twer on 6/25/15.
 */
public class DataService {
    private HashMap<String, Course> data = new HashMap<>();

    private DataService() {
    }

    // TODO: make it singleton
    public static DataService getInstance() {
        return new DataService();
    }

    public void saveSchedulingCourse(String name, Course course) {
        this.data.put(name, course);
    }

    public Course retrieveSchedulingCourse(String name) {
        return this.data.get(name);
    }
}
