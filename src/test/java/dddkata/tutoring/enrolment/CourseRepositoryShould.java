package dddkata.tutoring.enrolment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/25/15.
 */
public class CourseRepositoryShould {
    @Test
    public void persist_existing_course() {
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
}
