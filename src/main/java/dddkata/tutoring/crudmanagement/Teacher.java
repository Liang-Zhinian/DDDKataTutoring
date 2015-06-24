package dddkata.tutoring.crudmanagement;

/**
 * Created by twer on 6/24/15.
 */
public class Teacher {
    private String mobile;
    private String name;

    private Teacher() {

    }

    private Teacher(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public static Teacher create(String name, String mobile) {
        Teacher teacher = new Teacher(name, mobile);
        return teacher;
    }

    @Override
    public String toString() {
        return name + ": " + mobile + " ";
    }
}
