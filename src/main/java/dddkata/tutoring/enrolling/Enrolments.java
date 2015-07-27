package dddkata.tutoring.enrolling;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by twer on 6/26/15.
 */
public class Enrolments {
    private HashMap<String, Course> courses = new HashMap<>();
    private HashMap<String, Course> conflictedCourses = null;
    private HashMap<String, Course> kidAndEnrolledCourse = new HashMap<>();
    private EnrollingTranslator translator;

    private Enrolments(String schoolName) {
        this.translator = EnrollingTranslator.newInstance();
    }

    public static Enrolments newInstance(String schoolName) {
        return new Enrolments(schoolName);
    }

    public void addCourse(Course course) {
        if (translator.doesCourseExistInScheduling(course.getName())) {
            this.courses.put(course.getName(), course);
        }
    }

    public Map<String, Course> getConflictedCourses() {
        return conflictedCourses;
    }

    public void enrol(Enrolment enrolment, String courseName) {
        if (this.kidAndEnrolledCourse.size() > 0
                && this.kidAndEnrolledCourse.keySet().contains(enrolment.getKidName())) {
            markTwoConflictedCourses(courseName);
        }
        this.courses.get(courseName).enrol(enrolment);
        this.kidAndEnrolledCourse.put(enrolment.getKidName(), this.courses.get(courseName));
    }

    private void markTwoConflictedCourses(String courseNameJustAdded) {
        conflictedCourses = new HashMap<>();
        for(Map.Entry<String, Course> courseWithName : courses.entrySet()) {
            if ( !courseNameJustAdded.equals(courseWithName.getKey())
                    && translator.areTwoCoursesOverlapped(courseWithName.getValue(), this.courses.get(courseNameJustAdded))) {
                conflictedCourses.put(courseWithName.getKey(), courseWithName.getValue());
                conflictedCourses.put(this.courses.get(courseNameJustAdded).getName()
                , this.courses.get(courseNameJustAdded));
                break;
            }
        }
    }

    public int getQuantityOfAddedCourses() {
        return this.courses.size();
    }

    public boolean haveKidsEnrolledCourse(String courseName) {
        return this.kidAndEnrolledCourse.values().contains(courseName);
    }
}
