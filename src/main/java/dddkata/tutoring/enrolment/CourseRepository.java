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

    public Enrolment retrieveAKidForACourse(String courseName, String kidName) {
        Enrolment enrolment = this.dataService.retrieveAKidForACourse(courseName, kidName);
        return enrolment;
    }
}
