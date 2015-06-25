package dddkata.tutoring.enrolment;

/**
 * Created by twer on 6/25/15.
 */
public class Guardian {
    private final String relation;
    private final String mobile;

    private Guardian(String relation, String mobile) {
        this.relation = relation;
        this.mobile = mobile;
    }

    public static Guardian newInstance(String relation, String mobile) {
        return new Guardian(relation, mobile);
    }

    @Override
    public String toString() {
        return relation + "_" + mobile;
    }
}
