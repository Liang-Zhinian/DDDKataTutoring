package dddkata.tutoring.enrolling;

/**
 * Created by twer on 6/25/15.
 */
public class Fee {
    private final String date;
    private final int amount;

    private Fee(String date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public static Fee newInstance(String date, int amount) {
        return new Fee(date, amount);
    }

    @Override
    public String toString() {
        return date + "_" + amount;
    }
}
