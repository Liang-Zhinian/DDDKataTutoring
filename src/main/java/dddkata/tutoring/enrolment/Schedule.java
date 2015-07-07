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
    private EnrolmentTranslator translator;

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

    public void addKid(Kid kid, String courseName) {
        if (this.kidAndEnrolledCourse.size() > 0
                && this.kidAndEnrolledCourse.keySet().contains(kid.getName())) {
            markTwoConflictedCourses(courseName, this.translator.getScheduleInScheduling());
        }
        this.courses.get(courseName).addKid(kid);
        this.kidAndEnrolledCourse.put(kid.getName(), this.courses.get(courseName));
    }

    private void markTwoConflictedCourses(String courseNameJustAdded, dddkata.tutoring.scheduling.Schedule scheduleInScheduling) {
        conflictedCourses = new HashMap<>();
        for(Map.Entry<String, Course> courseWithName : courses.entrySet()) {
            if ( !courseNameJustAdded.equals(courseWithName.getKey())
                    && isOverlapped(courseWithName.getValue(), this.courses.get(courseNameJustAdded), scheduleInScheduling)) {
                conflictedCourses.put(courseWithName.getKey(), courseWithName.getValue());
                conflictedCourses.put(this.courses.get(courseNameJustAdded).getName()
                , this.courses.get(courseNameJustAdded));
                break;
            }
        }
    }

    private boolean isOverlapped(Course thisCourse, Course thatCourse, dddkata.tutoring.scheduling.Schedule scheduleInScheduling) {
        return scheduleInScheduling.isOverlapped(thisCourse.getName(), thatCourse.getName());
    }

    public void addTranslator(EnrolmentTranslator translator) {
        this.translator = translator;
    }
}
