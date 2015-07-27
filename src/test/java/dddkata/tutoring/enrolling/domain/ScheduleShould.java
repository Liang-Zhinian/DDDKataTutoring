package dddkata.tutoring.enrolling.domain;

import dddkata.tutoring.enrolling.domain.*;
import dddkata.tutoring.enrolling.domain.Course;
import dddkata.tutoring.scheduling.domain.DateRange;
import dddkata.tutoring.scheduling.domain.*;
import dddkata.tutoring.scheduling.domain.Teacher;
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
    public void ensure_that_the_course_to_be_added_must_be_created_in_scheduling() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        dddkata.tutoring.scheduling.domain.Course coursePictureBooksInScheduling
                = dddkata.tutoring.scheduling.domain.Course.newInstance("儿童绘本",
                "儿童用文字与图画去组织和表达思想的过程中，可以培养其对图画进行细致的经营，培养在生活中的观察力从而完整地创作出作品；在大量兼具艺术性与",
                "5～8岁",
                3000, "达芬奇", teachers, dateRange);
        Schedule scheduleInScheduling
                = Schedule.newInstance("小画家");
        scheduleInScheduling.addCourse(coursePictureBooksInScheduling);

        teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        dddkata.tutoring.scheduling.domain.Course courseHandwritingInScheduling
                = dddkata.tutoring.scheduling.domain.Course.newInstance("书法",
                "书法的字体结构与笔画线条的教学，培养儿童对中国文化的理解与表达能力。书法是以书法技法学习为途径，通过对汉字艺术造型演化的了解，获得传统文",
                "5～8岁",
                2000, "毕加索", teachers, dateRange);
        scheduleInScheduling.addCourse(courseHandwritingInScheduling);

        ScheduleRepository scheduleRepository = ScheduleRepository.newInstance();
        scheduleRepository.save(scheduleInScheduling);

        // Act
        Enrolments enrolmentsInEnrolment
                = Enrolments.newInstance("小画家");
        Course coursePictureBooksInEnrolment
                = Course.newInstance("儿童油画");
        Course courseHandwritingInEnrolment
                = Course.newInstance("书法");
        enrolmentsInEnrolment.addCourse(coursePictureBooksInEnrolment);
        enrolmentsInEnrolment.addCourse(courseHandwritingInEnrolment);

        // Assert
        assertEquals(1, enrolmentsInEnrolment.getQuantityOfAddedCourses());
    }

    @Test
    public void let_me_know_if_a_kid_enrolled_a_course_which_have_a_time_conflict_with_another_course_enrolled_by_the_same_kid() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        dddkata.tutoring.scheduling.domain.Course coursePictureBooksInScheduling
                = dddkata.tutoring.scheduling.domain.Course.newInstance("儿童绘本",
                "儿童用文字与图画去组织和表达思想的过程中，可以培养其对图画进行细致的经营，培养在生活中的观察力从而完整地创作出作品；在大量兼具艺术性与",
                "5～8岁",
                3000, "达芬奇", teachers, dateRange);
        Schedule scheduleInScheduling
                = Schedule.newInstance("小画家");
        scheduleInScheduling.addCourse(coursePictureBooksInScheduling);

        teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        dddkata.tutoring.scheduling.domain.Course courseHandwritingInScheduling
                = dddkata.tutoring.scheduling.domain.Course.newInstance("书法",
                "书法的字体结构与笔画线条的教学，培养儿童对中国文化的理解与表达能力。书法是以书法技法学习为途径，通过对汉字艺术造型演化的了解，获得传统文",
                "5～8岁",
                2000, "毕加索", teachers, dateRange);
        scheduleInScheduling.addCourse(courseHandwritingInScheduling);

        ScheduleRepository scheduleRepository = ScheduleRepository.newInstance();
        scheduleRepository.save(scheduleInScheduling);

        Enrolments enrolmentsInEnrolment
                = Enrolments.newInstance("小画家");
        Course coursePictureBooksInEnrolment
                = Course.newInstance("儿童绘本");
        Course courseHandwritingInEnrolment
                = Course.newInstance("书法");
        enrolmentsInEnrolment.addCourse(coursePictureBooksInEnrolment);
        enrolmentsInEnrolment.addCourse(courseHandwritingInEnrolment);

        // Act
        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFeeForPictureBooks = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSiForPictureBooks = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFeeForPictureBooks);
        enrolmentsInEnrolment.enrol(tianSiSiForPictureBooks, coursePictureBooksInEnrolment.getName());

        Fee tianSiSiFeeForHandwriting = Fee.newInstance("2015.02.16", 2000);
        Enrolment tianSiSiForHandwriting = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFeeForHandwriting);
        enrolmentsInEnrolment.enrol(tianSiSiForHandwriting, courseHandwritingInEnrolment.getName());

        Map<String, Course> conflictedCourses
                = enrolmentsInEnrolment.getConflictedCourses();

        // Assert
        assertEquals(coursePictureBooksInEnrolment, conflictedCourses.get("儿童绘本"));
        assertEquals(courseHandwritingInEnrolment, conflictedCourses.get("书法"));
    }
}
