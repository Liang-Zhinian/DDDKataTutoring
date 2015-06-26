package dddkata.tutoring.enrolment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by twer on 6/26/15.
 */
public class Schedule {
    private HashMap<String, Course> courses = new HashMap<>();
    private HashMap<String, Course> conflictedCourses = null;
    private HashMap<String, Course> kidAndEnrolledCourse = new HashMap<>();

    private Schedule(String schoolName) {

    }

    public static Schedule newInstance(String schoolName) {
        return new Schedule(schoolName);
    }

    public void addCourse(Course course) {
        this.courses.put(course.getName(), course);
    }

    public Map<String, Course> getConflictedCourses() {
        return conflictedCourses;
    }

    public void addKid(Kid kid, String courseName, dddkata.tutoring.scheduling.Schedule scheduleInScheduling) {
        if (this.kidAndEnrolledCourse.size() > 0
                && this.kidAndEnrolledCourse.keySet().contains(kid.getName())) {
            markTwoConflictedCourses(courseName, scheduleInScheduling);
        }
        this.courses.get(courseName).addKid(kid);
        this.kidAndEnrolledCourse.put(kid.getName(), this.courses.get(courseName));
    }

    private void markTwoConflictedCourses(String courseStringJustAdded, dddkata.tutoring.scheduling.Schedule scheduleInScheduling) {
        conflictedCourses = new HashMap<>();
        for(Map.Entry<String, Course> courseWithName : courses.entrySet()) {
            if ( !courseStringJustAdded.equals(courseWithName.getKey()) && isOverlapped(courseWithName.getValue(), this.courses.get(courseStringJustAdded), scheduleInScheduling)) {
                conflictedCourses.put(courseWithName.getKey(), courseWithName.getValue());
                conflictedCourses.put(this.courses.get(courseStringJustAdded).getName()
                , this.courses.get(courseStringJustAdded));
                break;
            }
        }
    }

    private boolean isOverlapped(Course thisCourse, Course thatCourse, dddkata.tutoring.scheduling.Schedule scheduleInScheduling) {
        return scheduleInScheduling.isOverlapped(thisCourse.getName(), thatCourse.getName());
    }
}
