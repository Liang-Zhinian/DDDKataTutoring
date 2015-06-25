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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kid kid = (Kid) o;

        if (age != kid.age) return false;
        if (!fee.equals(kid.fee)) return false;
        if (!gender.equals(kid.gender)) return false;
        if (!guardian.equals(kid.guardian)) return false;
        if (!name.equals(kid.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gender.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + guardian.hashCode();
        result = 31 * result + fee.hashCode();
        result = 31 * result + age;
        return result;
    }
}
