Feature: Create a course
  As Miss Hehe
  I want to create a course
  so that I can publish the course to guardians

  Scenario: What if there is a mandatory field which is not filled?
    Given all fields of a course are mandatory
    And the course description is left blank
    When create the course
    Then the course could not be created
    And An error message is prompted.
