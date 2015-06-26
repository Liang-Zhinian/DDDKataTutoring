package dddkata.tutoring.scheduling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/25/15.
 */
public class ScheduleShould {
    @Test
    public void let_me_know_if_two_courses_are_arranged_in_the_same_room_within_the_same_time_range() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course coursePreparatory = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        Schedule schedule = Schedule.newInstance("小画家");
        schedule.addCourse(coursePreparatory);

        teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("杆子", "18976876567"));
        dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course courseHandwriting = Course.newInstance("书法",
                "书法的字体结构与笔画线条的教学，培养儿童对中国文化的理解与表达能力。书法是以书法技法学习为途径，通过对汉字艺术造型演化的了解，获得传统文",
                "5～8岁",
                2000, "达芬奇", teachers, dateRange);
        schedule.addCourse(courseHandwriting);

        // Act
        Map<String, Course> conflictedCourses = schedule.getConflictedCourses();

        // Assert
        assertEquals(coursePreparatory, conflictedCourses.get("美术预科"));
        assertEquals(courseHandwriting, conflictedCourses.get("书法"));
    }

    @Test
    public void let_me_know_if_two_courses_are_arranged_for_one_teacher_within_the_same_time_range() {
        // Arrange & Act
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course coursePreparatory = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        Schedule schedule = Schedule.newInstance("小画家");
        schedule.addCourse(coursePreparatory);

        teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course courseHandwriting = Course.newInstance("书法",
                "书法的字体结构与笔画线条的教学，培养儿童对中国文化的理解与表达能力。书法是以书法技法学习为途径，通过对汉字艺术造型演化的了解，获得传统文",
                "5～8岁",
                2000, "毕加索", teachers, dateRange);
        schedule.addCourse(courseHandwriting);

        Map<String, Course> conflictedCourses = schedule.getConflictedCourses();

        // Assert
        assertEquals(coursePreparatory, conflictedCourses.get("美术预科"));
        assertEquals(courseHandwriting, conflictedCourses.get("书法"));
    }

}
