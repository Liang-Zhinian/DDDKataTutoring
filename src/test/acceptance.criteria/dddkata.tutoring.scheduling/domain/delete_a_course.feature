Feature: Delete a course
  As Miss Hehe
  I want to delete a course
  so that I can eliminate the information of the course I do not want

  Scenario: What if the course I want to delete has been enrolled by some kids?
    Given a course has an enrolment item
    When delete the course
    Then the course could not be deleted
    And an error message is prompted.
