package dddkata.tutoring.enrolling;

/**
 * Created by twer on 6/25/15.
 */
public class Enrolment {
    private String gender;
    private String kidName;
    private Guardian guardian;
    private Fee fee;
    private int age;

    private Enrolment(String kidName, String gender, int age, Guardian guardian, Fee fee) {
        this.kidName = kidName;
        this.gender = gender;
        this.age = age;
        this.guardian = guardian;
        this.fee = fee;
    }

    public static Enrolment newInstance(String name, String gender, int age, Guardian guardian, Fee fee) {
        return new Enrolment(name, gender, age, guardian, fee);
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public Fee getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return this.kidName + "_" + this.gender + "_" + this.age + "岁 ";
    }

    public String getKidName() {
        return kidName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enrolment enrolment = (Enrolment) o;

        if (age != enrolment.age) return false;
        if (!fee.equals(enrolment.fee)) return false;
        if (!gender.equals(enrolment.gender)) return false;
        if (!guardian.equals(enrolment.guardian)) return false;
        if (!kidName.equals(enrolment.kidName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gender.hashCode();
        result = 31 * result + kidName.hashCode();
        result = 31 * result + guardian.hashCode();
        result = 31 * result + fee.hashCode();
        result = 31 * result + age;
        return result;
    }
}
