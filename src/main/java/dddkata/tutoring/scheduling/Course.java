package dddkata.tutoring.scheduling;

import java.util.List;

/**
 * Created by twer on 6/24/15.
 */
public class Course {
    private final String name;
    private DateRange dateRange;
    private String description;
    private String age;
    private int fee;
    private String room;
    private List<Teacher> teachers;

    private Course(String name) {
        this.name = name;
    }

    public DateRange getDateRange() {
        return this.dateRange;
    }

    public String getEndDate() {
        String endDate = this.dateRange.getEndDate();
        return endDate;
    }

    public static Course newInstance(String name, String description, String age, int fee, String room, List<Teacher> teachers, DateRange dateRange) {
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

    public String getTeachersAndMobiles() {
        StringBuffer teachersAndMobiles = new StringBuffer();
        this.teachers.forEach(teacher -> teachersAndMobiles.append(teacher.toString()));
        return teachersAndMobiles.toString();
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (fee != course.fee) return false;
        if (!age.equals(course.age)) return false;
        if (!dateRange.equals(course.dateRange)) return false;
        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (!name.equals(course.name)) return false;
        if (!room.equals(course.room)) return false;
        if (!teachers.equals(course.teachers)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + dateRange.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + age.hashCode();
        result = 31 * result + fee;
        result = 31 * result + room.hashCode();
        result = 31 * result + teachers.hashCode();
        return result;
    }

    public boolean conflictsWith(Course course) {
        if (!this.name.equals(course.getName()) && this.room.equals(course.getRoom())
                && this.dateRange.conflictsWith(course.getDateRange())) {
            return true;
        }
        return false;
    }
}
