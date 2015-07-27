package dddkata.tutoring.scheduling.domain;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by twer on 7/27/15.
 */
public class CreateACourseStepDef {
    @Given("^a course has been created$")
    public void a_course_has_been_created() throws Throwable {
    }

    @When("^create second course in conflict with the first one over the same classroom$")
    public void create_second_course_in_conflict_with_the_first_one_over_the_same_classroom() throws Throwable {
    }

    @Then("^the second course could be created$")
    public void the_second_course_could_be_created() throws Throwable {
    }

    @And("^both conflicted courses should be mentioned in an error message$")
    public void both_conflicted_courses_should_be_mentioned_in_an_error_message() throws Throwable {
    }
}
