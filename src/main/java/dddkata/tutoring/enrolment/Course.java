package dddkata.tutoring.enrolment;

import java.util.HashMap;

/**
 * Created by twer on 6/24/15.
 */
public class Course {
    private final String name;
    private HashMap<String, Enrolment> kids = new HashMap<>();

    private Course(String name) {
        this.name = name;
    }

    public String getKidsWithGenderAndAge() {
        StringBuffer kidsWithGenderAndAge = new StringBuffer();
        this.kids.values().forEach(kid -> kidsWithGenderAndAge.append(kid.toString()));
        return kidsWithGenderAndAge.toString();
    }

    public static Course newInstance(String name) {
        return new Course(name);
    }

    public void addKid(Enrolment enrolment) {
        this.kids.put(enrolment.getKidName(), enrolment);
    }

    public String getGuardianFor(String kidName) {
        Enrolment enrolment = kids.get(kidName);
        String guardian = enrolment.getGuardian().toString();
        return guardian;
    }

    public String getFeeFor(String kidName) {
        Enrolment enrolment = kids.get(kidName);
        String fee = enrolment.getFee().toString();
        return fee;
    }

    public HashMap<String, Enrolment> getKids() {
        return kids;
    }

    public String getName() {
        return name;
    }

    public Enrolment getKid(String name) {
        return this.kids.get(name);
    }
}
