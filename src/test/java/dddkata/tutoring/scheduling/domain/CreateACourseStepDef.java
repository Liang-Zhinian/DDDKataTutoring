package dddkata.tutoring.scheduling.domain;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 7/27/15.
 */
public class CreateACourseStepDef {

    private List<Teacher> teachers;
    private DateRange dateRange;
    private final Schedule schedule = Schedule.newInstance("小画家");

    @Given("^a course has been created$")
    public void a_course_has_been_created() throws Throwable {
        teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course coursePreparatory = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        schedule.addCourse(coursePreparatory);
    }

    @When("^create second course in conflict with the first one over the same classroom$")
    public void create_second_course_in_conflict_with_the_first_one_over_the_same_classroom() throws Throwable {
        teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("杆子", "18976876567"));
        dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course courseHandwriting = Course.newInstance("书法",
                "书法的字体结构与笔画线条的教学，培养儿童对中国文化的理解与表达能力。书法是以书法技法学习为途径，通过对汉字艺术造型演化的了解，获得传统文",
                "5～8岁",
                2000, "达芬奇", teachers, dateRange);
        schedule.addCourse(courseHandwriting);
    }

    @Then("^the second course could be created and both conflicted courses should be identified$")
    public void the_second_course_could_be_created_and_both_conflicted_courses_should_be_identified() throws Throwable {
        Map<String, Course> conflictedCourses = schedule.getConflictedCourses();
        assertEquals("美术预科", conflictedCourses.get("美术预科").getName());
        assertEquals("书法", conflictedCourses.get("书法").getName());
    }
}
