package dddkata.tutoring.scheduling;


import dddkata.tutoring.sharedService.DataService;

/**
 * Created by twer on 6/24/15.
 */
public class CourseRepository {

    private DataService dataService = DataService.getInstance();

    public void save(String name, Course course) {
        dataService.saveSchedulingCourse(name, course);
    }

    public Course retrieve(String name) {
        return dataService.retrieveSchedulingCourse(name);
    }
}
