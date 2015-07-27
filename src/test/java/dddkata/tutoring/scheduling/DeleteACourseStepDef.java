package dddkata.tutoring.scheduling;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dddkata.tutoring.enrolment.Enrolment;
import dddkata.tutoring.enrolment.Fee;
import dddkata.tutoring.enrolment.Guardian;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twer on 7/27/15.
 */
public class DeleteACourseStepDef {
    @Given("^the Picture Books course has an enrolment item$")
    public void the_Picture_Books_course_has_an_enrolment_item() throws Throwable {
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course coursePictureBooksInScheduling
                = Course.newInstance("儿童绘本",
                "儿童用文字与图画去组织和表达思想的过程中，可以培养其对图画进行细致的经营，培养在生活中的观察力从而完整地创作出作品；在大量兼具艺术性与",
                "5～8岁",
                3000, "达芬奇", teachers, dateRange);
        Schedule scheduleInScheduling
                = Schedule.newInstance("小画家");
        scheduleInScheduling.addCourse(coursePictureBooksInScheduling);

        // TODO-working-on: Translator should be created in the scheduleInEnrolment

        dddkata.tutoring.enrolment.Schedule scheduleInEnrolment
                = dddkata.tutoring.enrolment.Schedule.newInstance("小画家");
        dddkata.tutoring.enrolment.Course coursePictureBooksInEnrolment
                = dddkata.tutoring.enrolment.Course.newInstance("儿童绘本");
        scheduleInEnrolment.addCourse(coursePictureBooksInEnrolment);

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFeeForPictureBooks = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSiForPictureBooks = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFeeForPictureBooks);
        scheduleInEnrolment.enrol(tianSiSiForPictureBooks, coursePictureBooksInEnrolment.getName());
    }

    @When("^delete the course$")
    public void delete_the_course() throws Throwable {
        // scheduleInScheduling.deleteCourse("儿童绘本");
    }

    @Then("^the course could not be deleted$")
    public void the_course_could_not_be_deleted() throws Throwable {
    }

    @And("^the message 'Some kids have enrolled the course. In order to delete the course, you have to delete all its enrolment items first.'$")
    public void the_message_Some_kids_have_enrolled_the_course_In_order_to_delete_the_course_you_have_to_delete_all_its_enrolment_items_first_() throws Throwable {
    }

}
