Feature: Delete a course
  As Miss Hehe
  I want to delete a course
  so that I can eliminate the information of the course I do not want

  Scenario: What if the course I want to delete has been enrolled by some kids?
    Given the Picture Books course has an enrolment item
    When delete the course
    Then the course could not be deleted
    And the message 'Some kids have enrolled the course. In order to delete the course, you have to delete all its enrolment items first.'
