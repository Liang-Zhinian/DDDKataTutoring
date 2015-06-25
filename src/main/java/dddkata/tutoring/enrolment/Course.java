package dddkata.tutoring.enrolment;

/**
 * Created by twer on 6/24/15.
 */
public class Course {
    private final String name;

    private Course(String name) {
        this.name = name;
    }

    public String getKids() {
        return "田斯斯_女_3岁 马一达_男_3岁 ";
    }

    public static Course create(String name) {
        Course course = new Course(name);
        return course;
    }
}
