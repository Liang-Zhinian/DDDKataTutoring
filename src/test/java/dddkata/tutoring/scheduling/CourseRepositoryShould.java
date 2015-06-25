package dddkata.tutoring.scheduling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/24/15.
 */
public class CourseRepositoryShould {

    @Test
    public void persistNewCourse() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course courseToBeCreated = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        CourseRepository repository = CourseRepository.newInstance();

        // Act
        repository.save("美术预科", courseToBeCreated);

        // Assert
        Course courseRetrieved = repository.retrieve("美术预科");
        assertEquals(courseToBeCreated, courseRetrieved);
    }

    @Test
    public void persistExistingCourse() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course courseToBeCreated = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        CourseRepository repository = CourseRepository.newInstance();

        // Act
        repository.save("美术预科", courseToBeCreated);
        Course courseUpdated = Course.newInstance("美术预科",
                "",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        repository.save("美术预科", courseUpdated);


        // Assert
        Course courseRetrieved = repository.retrieve("美术预科");
        assertEquals(courseUpdated, courseRetrieved);
    }

}
