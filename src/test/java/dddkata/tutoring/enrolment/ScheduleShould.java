package dddkata.tutoring.enrolment;

import dddkata.tutoring.scheduling.*;
import dddkata.tutoring.scheduling.Course;
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
    public void let_me_know_if_a_kid_enrolled_a_course_which_have_a_time_conflict_with_another_course() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        dddkata.tutoring.scheduling.Course coursePreparatoryInScheduling
                = dddkata.tutoring.scheduling.Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        dddkata.tutoring.scheduling.Schedule scheduleInScheduling
                = dddkata.tutoring.scheduling.Schedule.newInstance("小画家");
        scheduleInScheduling.addCourse(coursePreparatoryInScheduling);

        teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        dddkata.tutoring.scheduling.Course courseHandwritingInScheduling
                = dddkata.tutoring.scheduling.Course.newInstance("书法",
                "书法的字体结构与笔画线条的教学，培养儿童对中国文化的理解与表达能力。书法是以书法技法学习为途径，通过对汉字艺术造型演化的了解，获得传统文",
                "5～8岁",
                2000, "毕加索", teachers, dateRange);
        scheduleInScheduling.addCourse(courseHandwritingInScheduling);

        dddkata.tutoring.enrolment.Schedule scheduleInEnrolment
                = dddkata.tutoring.enrolment.Schedule.newInstance("小画家");
        dddkata.tutoring.enrolment.Course coursePreparatoryInEnrolment
                = dddkata.tutoring.enrolment.Course.newInstance("美术预科");
        dddkata.tutoring.enrolment.Course courseHandwritingInEnrolment
                = dddkata.tutoring.enrolment.Course.newInstance("书法");
        scheduleInEnrolment.addCourse(coursePreparatoryInEnrolment);
        scheduleInEnrolment.addCourse(courseHandwritingInEnrolment);

        // Act
        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFeeForPreparatory = Fee.newInstance("2015.02.15", 3000);
        Kid tianSiSiForPreparatory = Kid.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFeeForPreparatory);
        coursePreparatoryInEnrolment.addKid(tianSiSiForPreparatory);

        Fee tianSiSiFeeForHandwriting = Fee.newInstance("2015.02.16", 2000);
        Kid tianSiSiForHandwriting = Kid.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFeeForHandwriting);
        courseHandwritingInEnrolment.addKid(tianSiSiForHandwriting);

        Map<String, Course> conflictedCourses = scheduleInEnrolment.getConflictedCourses();

        // Assert
        assertEquals(coursePreparatoryInScheduling, conflictedCourses.get("美术预科"));
        assertEquals(courseHandwritingInScheduling, conflictedCourses.get("书法"));
    }
}
