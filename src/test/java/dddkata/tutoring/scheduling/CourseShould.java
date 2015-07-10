package dddkata.tutoring.scheduling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/23/15.
 */
public class CourseShould {

    @Test
    public void help_miss_hehe_to_create_a_course() {
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
    public void help_miss_hehe_to_browse_all_courses_created() {
        // Arrange
        CourseRepository repository = CourseRepository.newInstance();

        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course courseToBeCreated = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        repository.save("美术预科", courseToBeCreated);

        teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("杆子", "18976876567"));
        dateRange = new DateRange("Thursday", "18:00", "19:30", "2015.02.12", 12);
        courseToBeCreated = Course.newInstance("书法",
                "书法的字体结构与笔画线条的教学，培养儿童对中国文化的理解与表达能力。书法是以书法技法学习为途径，通过对汉字艺术造型演化的了解，获得传统文",
                "5～8岁",
                2000, "毕加索", teachers, dateRange);
        repository.save("书法", courseToBeCreated);

        // Act
        List<Course> coursesRetrieved = repository.getAllCourses();

        // Assert
        assertEquals(2, coursesRetrieved.size());
    }

    @Test
    public void help_miss_hehe_to_update_a_course() {
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

    @Test
    public void help_miss_hehe_to_delete_a_course() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course courseToBeCreated = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);
        CourseRepository repository = CourseRepository.newInstance();
        repository.save("美术预科", courseToBeCreated);

        // Act
        repository.delete("美术预科");

        // Assert
        Course courseRetrieved = repository.retrieve("美术预科");
        assertEquals(null, courseRetrieved);
    }

    // TODO: help_miss_hehe_to_search_a_course

    @Test
    public void tell_me_the_end_date() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course course = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);

        // Act & Assert
        assertEquals("2015.04.29", course.getEndDate());
    }

    @Test
    public void tell_me_the_teachers() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        teachers.add(Teacher.newInstance("杆子", "18976876567"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course course = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);

        // Act & Assert
        assertEquals("幼幼: 13809878765 杆子: 18976876567 ", course.getTeachersAndMobiles());
    }

    @Test
    public void tell_me_the_room() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course course = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);

        // Act & Assert
        assertEquals("达芬奇", course.getRoom());
    }

    @Test
    public void tell_me_the_fee() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course course = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);

        // Act & Assert
        assertEquals(3000, course.getFee());
    }

    @Test
    public void tell_me_the_name() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course course = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);

        // Act & Assert
        assertEquals("美术预科", course.getName());
    }

    @Test
    public void tell_me_the_description() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course course = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);

        // Act & Assert
        assertEquals("针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                course.getDescription());
    }

    @Test
    public void tell_me_the_age_range_of_kids() {
        // Arrange
        List<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(Teacher.newInstance("幼幼", "13809878765"));
        DateRange dateRange = new DateRange("Wednesday", "18:00", "19:30", "2015.02.11", 12);
        Course course = Course.newInstance("美术预科",
                "针对2-3岁儿童心理、生理特点以及敏感期的发展特点，从最基础的看、摸、闻、听、尝（视觉、触觉、嗅觉、听觉、味觉）感觉入手，培养孩子最基础的",
                "2～3岁",
                3000, "达芬奇", teachers, dateRange);

        // Act & Assert
        assertEquals("2～3岁", course.getAge());
    }
}
