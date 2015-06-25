package dddkata.tutoring.enrolment;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by twer on 6/24/15.
 */
public class CourseShould {
    @Test
    public void tell_me_the_kids_enrolled() {
        // Arrange
        dddkata.tutoring.enrolment.Course course = dddkata.tutoring.enrolment.Course.newInstance("美术预科");

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Kid tianSiSi = Kid.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        course.addKid(tianSiSi);

        Guardian maYiDaDad = Guardian.newInstance("Dad", "13921223211");
        Fee maYiDaFee = Fee.newInstance("2015.02.16", 3000);
        Kid maYiDa = Kid.newInstance("马一达", "男", 3, maYiDaDad, maYiDaFee);
        course.addKid(maYiDa);

        // Act & Assert
        assertEquals("田斯斯_女_3岁 马一达_男_3岁 ", course.getKidsWithGenderAndAge());
    }

    @Test
    public void tell_me_the_guardian_for_a_kid() {
        // Arrange
        dddkata.tutoring.enrolment.Course course = dddkata.tutoring.enrolment.Course.newInstance("美术预科");

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Kid tianSiSi = Kid.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        course.addKid(tianSiSi);

        // Act & Assert
        assertEquals("Mom_13921223456", course.getGuardianFor("田斯斯"));
    }

    @Test
    public void tell_me_the_date_when_a_kids_fee_was_paid() {
        // Arrange
        dddkata.tutoring.enrolment.Course course = dddkata.tutoring.enrolment.Course.newInstance("美术预科");

        Guardian tianSiSiMom = Guardian.newInstance("Mom", "13921223456");
        Fee tianSiSiFee = Fee.newInstance("2015.02.15", 3000);
        Kid tianSiSi = Kid.newInstance("田斯斯", "女", 3, tianSiSiMom, tianSiSiFee);
        course.addKid(tianSiSi);

        // Act & Assert
        assertEquals("2015.02.15_3000", course.getFeeFor("田斯斯"));
    }
}
