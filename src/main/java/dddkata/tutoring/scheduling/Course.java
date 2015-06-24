package dddkata.tutoring.scheduling;

import dddkata.tutoring.crudmanagement.Teacher;

import java.util.List;

/**
 * Created by twer on 6/24/15.
 */
public class Course {
    private DateRange dateRange;
    private String description;
    private String age;
    private int fee;
    private String room;
    private List<Teacher> teachers;

    public Course(String name) {

    }

    public DateRange getDateRange() {
        return this.dateRange;
    }

    public String getEndDate() {
        return "2015.04.29";
    }

    public static Course create(String name, String description, String age, int fee, String room, List<Teacher> teachers, DateRange dateRange) {
        Course course = new Course(name);
        course.setDescription(description);
        course.setAge(age);
        course.setFee(fee);
        course.setRoom(room);
        course.setTeachers(teachers);
        course.setDateRange(dateRange);
        return course;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getFee() {
        return fee;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }
}
