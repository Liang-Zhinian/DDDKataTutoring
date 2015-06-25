package dddkata.tutoring.enrolment;

/**
 * Created by twer on 6/25/15.
 */
public class Guardian {
    private Guardian(String relation, String mobile) {

    }

    public static Guardian newInstance(String relation, String mobile) {
        return new Guardian(relation, mobile);
    }
}
