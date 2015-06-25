package dddkata.tutoring.scheduling;

import org.junit.Test;

/**
 * Created by twer on 6/25/15.
 */
public class ScheduleShould {
    @Test
    public void let_me_know_if_two_courses_are_arranged_in_the_same_room_within_the_same_time_range() {
        // Assert
        assertEquals(coursePreparatory, conflictedCourses.get("美术预科"));
        assertEquals(courseHandwriting, conflictedCourses.get("书法"));
    }

    // TODO: let_me_know_if_two_courses_are_arranged_for_one_teacher_within_the_same_time_range

}
