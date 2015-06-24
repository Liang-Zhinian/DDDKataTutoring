package dddkata.tutoring.enrolment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/24/15.
 */
public class CourseShould {
    @Test
    public void tellMeTheKidsEnrolled() {
        // Arrange
        dddkata.tutoring.enrolment.Course course = CourseRepository.getByName("美术预科");
        
        // Act & Assert
        assertEquals("田斯斯_女_3岁 马一达_男_3岁 ", course.getKids());
    }

    // TODO: tellMeTheGuardianForAKid
    // TODO: tellMeTheDateWhenAKidsFeeWasPaid
}
