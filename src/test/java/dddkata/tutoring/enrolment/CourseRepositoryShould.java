package dddkata.tutoring.enrolment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/25/15.
 */
public class CourseRepositoryShould {
    @Test
    public void enrolAKidForACourse() {
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

    // TODO: updateKidInfoForACourse
    // TODO: deleteKidFromACourse
    // TODO: updateGuardianInfoOfAKidForACourse
    // TODO: updateFeeInfoOfAKidForACourse
}
