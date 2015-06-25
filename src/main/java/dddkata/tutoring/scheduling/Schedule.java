package dddkata.tutoring.scheduling;

import java.util.HashMap;

/**
 * Created by twer on 6/25/15.
 */
public class Schedule {
    private final String schoolName;
    private HashMap<String, Course> courses = new HashMap<>();
    private HashMap<String, Course> conflictedCourses = new HashMap<>();

    private Schedule(String schoolName) {
        this.schoolName = schoolName;
    }

    public static Schedule newInstance(String schoolName) {
        return new Schedule(schoolName);
    }

    public void addCourse(Course course) {
        this.courses.put(course.getName(), course);
        markConflictedCourses(course);
    }

    public HashMap<String, Course> getConflictedCourses() {
        return conflictedCourses;
    }
}
