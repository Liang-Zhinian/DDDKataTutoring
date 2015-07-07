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
        Kid kidToBeEnrolled = Kid.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        dddkata.tutoring.enrolment.CourseRepository repository =
                dddkata.tutoring.enrolment.CourseRepository.newInstance();
        Course course = Course.newInstance("美术预科");
        course.addKid(kidToBeEnrolled);

        // Act
        repository.enrolAKidForACourse("美术预科", course);

        // Assert
        Kid kidEnrolled = repository.retrieveAKidForACourse("美术预科", "田斯斯");
        assertEquals(kidToBeEnrolled, kidEnrolled);
    }

    @Test
    public void persist_existing_course() {
        // Arrange
        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Kid kidToBeEnrolled = Kid.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        CourseRepository repository =
                CourseRepository.newInstance();
        Course courseToBeCreated = Course.newInstance("美术预科");
        courseToBeCreated.addKid(kidToBeEnrolled);

        // Act
        repository.enrolAKidForACourse("美术预科", courseToBeCreated);
        Course courseUpdated = Course.newInstance("美术预科");
        Kid kidUpdated = Kid.newInstance("田斯斯", "女", 2, tianSiSiMom, tianSiSiFee);;
        courseUpdated.addKid(kidUpdated);
        repository.enrolAKidForACourse("美术预科", courseUpdated);

        // Assert
        Kid kidEnrolled = repository.retrieveAKidForACourse("美术预科", "田斯斯");
        assertEquals(kidUpdated, kidEnrolled);
    }
}
