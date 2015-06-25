package dddkata.tutoring.enrolment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twer on 6/24/15.
 */
public class Course {
    private final String name;
    private List<Kid> kids = new ArrayList<>();

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

    public static Course newInstance(String name) {
        return new Course(name);
    }

    public void addKid(Kid kid) {
        this.kids.add(kid);
    }
}
