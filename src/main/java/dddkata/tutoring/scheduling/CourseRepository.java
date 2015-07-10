package dddkata.tutoring.scheduling;

import java.util.List;

/**
 * Created by twer on 6/24/15.
 */
public class CourseRepository {

    private DataService dataService = DataService.getInstance();

    private CourseRepository() {

    }

    public void save(String name, Course course) {
        dataService.saveSchedulingCourse(name, course);
    }

    public Course retrieve(String name) {
        return dataService.retrieveSchedulingCourse(name);
    }

    public static CourseRepository newInstance() {
        return new CourseRepository();
    }

    public List<Course> getAllCourses() {
        return dataService.getAllSchedulingCourses();
    }
}
