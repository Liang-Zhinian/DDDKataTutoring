package dddkata.tutoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/23/15.
 */
public class CourseShould {
    @Test
    public void tellMeTheEndDate() {
        // Arrange
        Course course = new Course();

        // Act & Assert
        assertEquals("2015.04.29", course.getEndDate());
    }
}
