package dddkata.tutoring.enrolment;

/**
 * Created by twer on 6/24/15.
 */
public class CourseRepository {
    public static Course getByName(String courseName) {
        dddkata.tutoring.scheduling.Course courseInScheduling = getCourseInSchedulingByName(courseName);
        Course course = Course.create(courseInScheduling.getName());
        return course;
    }

    private static dddkata.tutoring.scheduling.Course getCourseInSchedulingByName(String courseName) {
        return courseRepositoryIn.retrieve("美术预科");
    }
}
