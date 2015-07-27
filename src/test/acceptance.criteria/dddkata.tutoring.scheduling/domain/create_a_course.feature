Feature: Create a course
  As Miss Hehe
  I want to create a course
  so that I can publish the course to guardians

  Scenario: What if there is a mandatory field which is not filled?
    Given all fields of a course are mandatory
    And the course description is left blank
    When create the course
    Then the course could not be created
    And An error message should be prompted

  Scenario: Can I retrieve it back after creating a course?
    Given all fields of a course have been filled
    When create the course
    And retrieve the same course by name
    Then the course retrieved should be the same as the one before the creation

  Scenario: What if the name of the course to be created exists?
    Given a course has been created
    When create the second course with the same name as the first one
    Then An error message should be prompted

  Scenario: What if a course has many teachers?
    Given all fields of a course with two teachers have been filled
    When create the course
    Then the course should have two teachers

  Scenario: What if the course is in conflict with another course over the same classroom?
    Given a course has been created
    When create second course in conflict with the first one over the same classroom
    Then the second course could be created and both conflicted courses should be identified

  Scenario: What if the course is in conflict with another course over the same teacher?
    Given a course has been created
    When create second course in conflict with the first one over the same teacher
    Then the second course could be created
    And both conflicted courses should be mentioned in an error message
