package dddkata.tutoring.enrolment;

/**
 * Created by twer on 6/25/15.
 */
public class CourseRepository {

    private DataService dataService = DataService.getInstance();

    private CourseRepository() {

    }

    public static CourseRepository newInstance() {
        return new CourseRepository();
    }

    public void enrolAKidForACourse(String courseName, Course enrolmentCourse) {
        this.dataService.enrolAKidForACourse(courseName, enrolmentCourse);
    }

    public Kid retrieveAKidForACourse(String courseName, String kidName) {
        Kid kid = this.dataService.retrieveAKidForACourse(courseName, kidName);
        return kid;
    }

    public Course retrieve(String courseName) {
        return this.dataService.retrieveCourse(courseName);
    }

    public void save(String courseName, Course course) {
        this.dataService.save(courseName, course);
    }
}
