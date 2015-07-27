Feature: Update a course
  As Miss Hehe
  I want to update a course
  so that I can fix the errors

  Scenario: How can I identify the course to be updated?
    Given a course has been created
    When retrieve the course by name
    And update its description
    Then the description of the course should be updated

  Scenario: What if there is a mandatory field which is not filled?
    Given all fields of a course are mandatory
    And a course has been created
    And retrieve the course by name
    And make the course description blank
    When update the course
    Then the course could not be created
    And An error message should be prompted

  Scenario: What if the course is in conflict with another course over the same classroom?
    Given the first course has been created
    And the second course has been created
    When change the settings of the second course so that it is in conflict with the first one over the same classroom
    And update the second course
    Then the second course could be created
    And both conflicted courses should be mentioned in an error message

  Scenario: What if the course is in conflict with another course over the same teacher?
    Given the first course has been created
    And the second course has been created
    When change the settings of the second course so that it is in conflict with the first one over the same teacher
    And update the second course
    Then the second course could be created
    And both conflicted courses should be mentioned in an error message

