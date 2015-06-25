package dddkata.tutoring.enrolment;

/**
 * Created by twer on 6/25/15.
 */
public class Kid {
    private String gender;
    private String name;
    private Guardian guardian;
    private Fee fee;
    private int age;

    private Kid(String name, String gender, int age, Guardian guardian, Fee fee) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.guardian = guardian;
        this.fee = fee;
    }

    public static Kid newInstance(String name, String gender, int age, Guardian guardian, Fee fee) {
        return new Kid(name, gender, age, guardian, fee);
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public Fee getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return this.name + "_" + this.gender + "_" + this.age + "岁 ";
    }

    public String getName() {
        return name;
    }
}
