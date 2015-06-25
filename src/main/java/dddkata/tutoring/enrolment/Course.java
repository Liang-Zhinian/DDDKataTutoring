package dddkata.tutoring.enrolment;

import java.util.HashMap;

/**
 * Created by twer on 6/24/15.
 */
public class Course {
    private final String name;
    private HashMap<String, Kid> kids = new HashMap<>();

    private Course(String name) {
        this.name = name;
    }

    public String getKids() {
        StringBuffer kidsWithGenderAndAge = new StringBuffer();
        this.kids.values().forEach(kid -> kidsWithGenderAndAge.append(kid.toString()));
        return kidsWithGenderAndAge.toString();
    }

    public static Course create(String name) {
        Course course = new Course(name);
        return course;
    }

    public static Course newInstance(String name) {
        return new Course(name);
    }

    public void addKid(Kid kid) {
        this.kids.put(kid.getName(), kid);
    }

    public String getGuardianFor(String kidName) {
        Kid kid = kids.get(kidName);
        String guardian = kid.getGuardian().toString();
        return guardian;
    }
}
