package dddkata.tutoring.enrolment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/25/15.
 */
public class CourseRepositoryShould {
    @Test
    public void persist_new_course() {
        // Arrange
        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment enrolmentToBeEnrolled = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        CourseRepository repository =
                CourseRepository.newInstance();
        Course course = Course.newInstance("美术预科");
        course.addKid(enrolmentToBeEnrolled);

        // Act
        repository.enrolAKidForACourse("美术预科", course);

        // Assert
        Enrolment enrolmentEnrolled = repository.retrieveAKidForACourse("美术预科", "田斯斯");
        assertEquals(enrolmentToBeEnrolled, enrolmentEnrolled);
    }

    @Test
    public void persist_existing_course() {
        // Arrange
        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Enrolment enrolmentToBeEnrolled = Enrolment.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        CourseRepository repository =
                CourseRepository.newInstance();
        Course courseToBeCreated = Course.newInstance("美术预科");
        courseToBeCreated.addKid(enrolmentToBeEnrolled);

        // Act
        repository.enrolAKidForACourse("美术预科", courseToBeCreated);
        Course courseUpdated = Course.newInstance("美术预科");
        Enrolment enrolmentUpdated = Enrolment.newInstance("田斯斯", "女", 2, tianSiSiMom, tianSiSiFee);;
        courseUpdated.addKid(enrolmentUpdated);
        repository.enrolAKidForACourse("美术预科", courseUpdated);

        // Assert
        Enrolment enrolmentEnrolled = repository.retrieveAKidForACourse("美术预科", "田斯斯");
        assertEquals(enrolmentUpdated, enrolmentEnrolled);
    }
}
