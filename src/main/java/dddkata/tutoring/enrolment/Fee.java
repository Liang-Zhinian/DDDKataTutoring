package dddkata.tutoring.enrolment;

/**
 * Created by twer on 6/25/15.
 */
public class Fee {
    public Fee(String date, int amount) {

    }

    public static Fee newInstance(String date, int amount) {
        return new Fee(date, amount);
    }
}
