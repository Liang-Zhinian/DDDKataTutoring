package dddkata.tutoring.enrolling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by twer on 6/24/15.
 */
public class Course {
    private final String name;
    private HashMap<String, Enrolment> enrolments = new HashMap<>();

    private Course(String name) {
        this.name = name;
    }

    public String getKidsWithGenderAndAge() {
        StringBuffer kidsWithGenderAndAge = new StringBuffer();
        this.enrolments.values().forEach(kid -> kidsWithGenderAndAge.append(kid.toString()));
        return kidsWithGenderAndAge.toString();
    }

    public static Course newInstance(String name) {
        return new Course(name);
    }

    public void enrol(Enrolment enrolment) {
        this.enrolments.put(enrolment.getKidName(), enrolment);
    }

    public String getGuardianFor(String kidName) {
        Enrolment enrolment = enrolments.get(kidName);
        String guardian = enrolment.getGuardian().toString();
        return guardian;
    }

    public String getFeeFor(String kidName) {
        Enrolment enrolment = enrolments.get(kidName);
        String fee = enrolment.getFee().toString();
        return fee;
    }

    public List<Enrolment> getEnrolments() {
        return new ArrayList<>(this.enrolments.values());
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Enrolment> getEnrolmentsWithKidNames() {
        return this.enrolments;
    }

    public void removeEnrolment(String kidName) {
        this.enrolments.remove(kidName);
    }
}
