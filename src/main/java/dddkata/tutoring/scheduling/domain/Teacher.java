package dddkata.tutoring.scheduling.domain;

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

    public static Teacher newInstance(String name, String mobile) {
        Teacher teacher = new Teacher(name, mobile);
        return teacher;
    }

    @Override
    public String toString() {
        return name + ": " + mobile + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (!mobile.equals(teacher.mobile)) return false;
        if (!name.equals(teacher.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mobile.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
