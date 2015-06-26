package dddkata.tutoring.enrolment;

/**
 * Created by twer on 6/26/15.
 */
public class Schedule {
    private Schedule(String schoolName) {

    }

    public static Schedule newInstance(String schoolName) {
        return new Schedule(schoolName);
    }

    public void addCourse(Course course) {

    }
}
