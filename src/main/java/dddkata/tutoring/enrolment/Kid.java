package dddkata.tutoring.enrolment;

/**
 * Created by twer on 6/25/15.
 */
public class Kid {
    private Guardian guardian;
    private Fee fee;

    private Kid(String name, String gender, int age) {

    }

    public static Kid newInstance(String name, String gender, int age) {
        return new Kid(name, gender, age);
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Fee getFee() {
        return fee;
    }
}
