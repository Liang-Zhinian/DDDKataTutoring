package dddkata.tutoring.enrolment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/24/15.
 */
public class CourseShould {

    @Test
    public void help_miss_hehe_to_create_an_enrolment_entry_for_a_course() {
        // Arrange
        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment enrolmentToBeEnrolled = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        CourseRepository repository =
                CourseRepository.newInstance();
        Course course = Course.newInstance("美术预科");
        course.addKid(enrolmentToBeEnrolled);

        // Act
        repository.enrolAKidForACourse(course.getName(), course);

        // Assert
        Enrolment enrolmentEnrolled = repository.retrieveAKidForACourse("美术预科", "田斯斯");
        assertEquals(enrolmentToBeEnrolled, enrolmentEnrolled);
    }

    @Test
    public void help_miss_hehe_to_browse_all_enrolment_entries_for_a_course() {
        // Assert
//        CourseRepository repository;
//        List<Enrolment> enrolmentRetrieved = repository.getAllEnrolmentFor("美术预科");
//        assertEquals(2, enrolmentRetrieved.size());
    }
    
    // TODO: help_miss_hehe_to_update_an_enrolment_entry_for_a_course
    // TODO: help_miss_hehe_to_delete_an_enrolment_entry_from_a_course
    // TODO: help_miss_hehe_to_list_the_information_of_all_kids_enrolled_in_a_course
    // TODO: help_miss_hehe_to_get_contact_information_of_a_kid_in_a_course
    // TODO: help_miss_hehe_to_get_payment_information_of_a_kid_in_a_course

    @Test
    public void tell_me_the_kids_enrolled() {
        // Arrange
        Course course = Course.newInstance("美术预科");

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSi = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        course.addKid(tianSiSi);

        Guardian maYiDaDad = Guardian.newInstance("Dad", "13921223211");
        Fee maYiDaFee = Fee.newInstance("2015.02.16", 3000);
        Enrolment maYiDa = Enrolment.newInstance("马一达", "男", 3, maYiDaDad, maYiDaFee);
        course.addKid(maYiDa);

        // Act & Assert
        assertEquals("田斯斯_女_3岁 马一达_男_3岁 ", course.getKidsWithGenderAndAge());
    }

    @Test
    public void tell_me_the_guardian_for_a_kid() {
        // Arrange
        Course course = Course.newInstance("美术预科");

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSi = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        course.addKid(tianSiSi);

        // Act & Assert
        assertEquals("Mom_13921223456", course.getGuardianFor("田斯斯"));
    }

    @Test
    public void tell_me_the_date_when_a_kids_fee_was_paid() {
        // Arrange
        Course course = Course.newInstance("美术预科");

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSi = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        course.addKid(tianSiSi);

        // Act & Assert
        assertEquals("2015.02.15_3000", course.getFeeFor("田斯斯"));
    }
}
