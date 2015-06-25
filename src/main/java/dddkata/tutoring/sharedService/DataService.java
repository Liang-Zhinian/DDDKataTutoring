package dddkata.tutoring.sharedService;

import dddkata.tutoring.scheduling.Course;

import java.util.HashMap;

/**
 * Created by twer on 6/25/15.
 */
public class DataService {
    private static DataService singleton;
    private HashMap<String, Course> data = new HashMap<>();

    private DataService() {
    }

    public static DataService getInstance() {
        if (singleton == null) {
            singleton = new DataService();
        }
        return singleton;
    }

    public void saveSchedulingCourse(String name, Course course) {
        this.data.put(name, course);
    }

    public Course retrieveSchedulingCourse(String name) {
        return this.data.get(name);
    }
}
