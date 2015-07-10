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
        CourseRepository repository =
                CourseRepository.newInstance();
        Course course = Course.newInstance("美术预科");
        repository.addCourse(course.getName(), course);

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSi = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);

        // Act
        repository.enrolAKidForACourse("美术预科", tianSiSi);

        // Assert
        Enrolment enrolmentEnrolled = repository.retrieveAKidForACourse("美术预科", "田斯斯");
        assertEquals(tianSiSi, enrolmentEnrolled);
    }

    @Test
    public void help_miss_hehe_to_browse_all_enrolment_entries_for_a_course() {
        // Arrange
        CourseRepository repository = CourseRepository.newInstance();
        Course course = Course.newInstance("美术预科");
        repository.addCourse(course.getName(), course);

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSi = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        repository.enrolAKidForACourse("美术预科", tianSiSi);

        Guardian maYiDaDad = Guardian.newInstance("Dad", "13921223211");
        Fee maYiDaFee = Fee.newInstance("2015.02.16", 3000);
        Enrolment maYiDa = Enrolment.newInstance("马一达", "男", 3, maYiDaDad, maYiDaFee);
        repository.enrolAKidForACourse("美术预科", maYiDa);

        // Act & Assert
        assertEquals("田斯斯_女_3岁 马一达_男_3岁 ", course.getKidsWithGenderAndAge());
    }

    @Test
    public void help_miss_hehe_to_update_an_enrolment_entry_for_a_course() {
        // Arrange
        CourseRepository repository =
                CourseRepository.newInstance();
        Course course = Course.newInstance("美术预科");
        repository.addCourse(course.getName(), course);

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSi = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);

        // Act
        repository.enrolAKidForACourse("美术预科", tianSiSi);

        Enrolment tianSiSiUpdated = Enrolment.newInstance("田斯斯", "女", 2, tianSiSiMom, tianSiSiFee);;
        repository.enrolAKidForACourse("美术预科", tianSiSiUpdated);

        // Assert
        Enrolment enrolmentEnrolled = repository.retrieveAKidForACourse("美术预科", "田斯斯");
        assertEquals(tianSiSiUpdated, enrolmentEnrolled);
    }

    @Test
    public void help_miss_hehe_to_delete_an_enrolment_entry_from_a_course() {
        // Arrange
        CourseRepository repository =
                CourseRepository.newInstance();
        Course course = Course.newInstance("美术预科");
        repository.addCourse(course.getName(), course);

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSi = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        repository.enrolAKidForACourse("美术预科", tianSiSi);

        // Act
        repository.removeAKidFromACourse("美术预科", "田斯斯");

        // Assert
        Enrolment enrolmentRetrieved = repository.retrieveAKidForACourse("美术预科", "田斯斯");
        assertEquals(null, enrolmentRetrieved);
    }

    @Test
    public void help_miss_hehe_to_get_contact_information_of_a_kid_in_a_course() {
        // Arrange
        CourseRepository repository =
                CourseRepository.newInstance();
        Course course = Course.newInstance("美术预科");
        repository.addCourse(course.getName(), course);

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSi = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        repository.enrolAKidForACourse("美术预科", tianSiSi);

        // Act & Assert
        assertEquals("Mom_13921223456", repository.getCourse("美术预科").getGuardianFor("田斯斯"));
    }

    @Test
    public void help_miss_hehe_to_get_payment_information_of_a_kid_in_a_course() {
        // Arrange
        CourseRepository repository =
                CourseRepository.newInstance();
        Course course = Course.newInstance("美术预科");
        repository.addCourse(course.getName(), course);

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment tianSiSi = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        repository.enrolAKidForACourse("美术预科", tianSiSi);

        // Act & Assert
        assertEquals("2015.02.15_3000", course.getFeeFor("田斯斯"));
    }
}
