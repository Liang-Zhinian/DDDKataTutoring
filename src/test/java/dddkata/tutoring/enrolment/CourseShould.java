package dddkata.tutoring.enrolment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/24/15.
 */
public class CourseShould {
    @Test
    public void tellMeTheKidsEnrolled() {
        // Assert
        assertEquals("田斯斯_女_3岁 马一达_男_3岁 ", course.getKids());
    }

    // TODO: tellMeTheGuardianForAKid
    // TODO: tellMeTheDateWhenAKidsFeeWasPaid
}
