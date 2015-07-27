package dddkata.tutoring.scheduling.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by twer on 6/25/15.
 */
public class Schedule {
    private final String schoolName;
    private Map<String, Course> courses = new HashMap<>();
    private Map<String, Course> conflictedCourses = null;
    private String message = "";

    private Schedule(String schoolName) {
        this.schoolName = schoolName;
    }

    public static Schedule newInstance(String schoolName) {
        return new Schedule(schoolName);
    }

    public void addCourse(Course course) {
        if (this.courses.size() > 0) {
            markTwoConflictedCourses(course);
        }
        this.courses.put(course.getName(), course);
    }

    private void markTwoConflictedCourses(Course courseJustAdded) {
        conflictedCourses = new HashMap<>();
        for(Map.Entry<String, Course> courseWithName : courses.entrySet()) {
            if (courseJustAdded.conflictsWith(courseWithName.getValue())) {
                conflictedCourses.put(courseJustAdded.getName(), courseJustAdded);
                conflictedCourses.put(courseWithName.getKey(), courseWithName.getValue());
                break;
            }
        }
    }

    public Map<String, Course> getConflictedCourses() {
        return conflictedCourses;
    }

    public boolean isOverlapped(String thisCourseName, String thatCourseName) {
        Course thisCourse = this.courses.get(thisCourseName);
        Course thatCourse = this.courses.get(thatCourseName);
        return thisCourse.isOverlappedWith(thatCourse);
    }

    public boolean isCourseCreated(String courseName) {
        return this.courses.keySet().contains(courseName);
    }

    public void deleteCourse(String courseName) {
        SchedulingTranslator schedulingTranslator = SchedulingTranslator.newInstance();
        if (schedulingTranslator.haveKidsEnrolledCourse(courseName)) {
            this.message = "Some kids have enrolled the course. In order to delete the course, you have to delete all its enrolment items first.";
            return;
        }
        this.message = "Course deleted successfully.";
        this.courses.remove("courseName");
    }

    public boolean containsCourse(String courseName) {
        return this.courses.containsKey(courseName);
    }

    public String getMessage() {
        return this.message;
    }
}
