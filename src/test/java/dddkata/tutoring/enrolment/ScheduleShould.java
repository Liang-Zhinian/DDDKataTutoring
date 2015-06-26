package dddkata.tutoring.enrolment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/25/15.
 */
public class ScheduleShould {
    @Test
    public void let_me_know_if_a_kid_enrolled_a_course_which_have_a_time_conflict_with_another_course() {
        // Assert
        assertEquals(courseHandwriting, conflictedCourse);
    }
}
