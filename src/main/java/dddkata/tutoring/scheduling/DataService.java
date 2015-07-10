package dddkata.tutoring.scheduling;

import java.util.ArrayList;
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

    public void saveSchedulingCourse(String name, Course course) {
        this.courses.put(name, course);
    }

    public Course retrieveSchedulingCourse(String name) {
        return this.courses.get(name);
    }

    public List<Course> getAllSchedulingCourses() {
        return new ArrayList<>(this.courses.values());
    }

    public void delete(String courseName) {
        this.courses.remove(courseName);
    }
}
