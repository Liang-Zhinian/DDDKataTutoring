package dddkata.tutoring.scheduling;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by twer on 7/27/15.
 */
public class CreateACourseStepDef {
    @cucumber.api.java.en.Given("^all fields of a course are mandatory$")
    public void all_fields_of_a_course_are_mandatory() throws Throwable {
    }

    @And("^the course description is left blank$")
    public void the_course_description_is_left_blank() throws Throwable {
    }

    @When("^create the course$")
    public void create_the_course() throws Throwable {
    }

    @Then("^the course could not be created$")
    public void the_course_could_not_be_created() throws Throwable {
    }

    @And("^An error message is prompted.$")
    public void An_error_message_is_prompted() throws Throwable {
    }
}
