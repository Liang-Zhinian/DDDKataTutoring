package dddkata.tutoring.scheduling;

import dddkata.tutoring.crudmanagement.Teacher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/23/15.
 */
public class CourseShould {
    @Test
    public void tellMeTheEndDate() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.create("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course course = Course.create("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);

        // Act & Assert
        assertEquals("2015.04.29", course.getEndDate());
    }

    @Test
    public void tellMeTheTeachers() {
        // Assert
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.create("幼幼", "13809878765"));
        teachers.add(Teacher.create("杆子", "18976876567"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course course = Course.create("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        assertEquals("幼幼: 13809878765 杆子: 18976876567 ", course.getTeachersAndMobiles());
    }

    // TODO: tellMeTheRoom
    // TODO: tellMeTheFee
    // TODO: tellMeTheName
    // TODO: tellMeTheDescription
    // TODO: tellMeTheAgeOfKids
}
