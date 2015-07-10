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
        if (translator.doesCourseExistInScheduling(course)) {
            this.courses.put(course.getName(), course);
        }
    }

    public Map<String, Course> getConflictedCourses() {
        return conflictedCourses;
    }

    public void addKid(Enrolment enrolment, String courseName) {
        if (this.kidAndEnrolledCourse.size() > 0
                && this.kidAndEnrolledCourse.keySet().contains(enrolment.getKidName())) {
            markTwoConflictedCourses(courseName);
        }
        this.courses.get(courseName).addKid(enrolment);
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

    public void addTranslator(EnrolmentTranslator translator) {
        this.translator = translator;
    }

    public int getQuantityOfAddedCourses() {
        return this.courses.size();
    }
}
