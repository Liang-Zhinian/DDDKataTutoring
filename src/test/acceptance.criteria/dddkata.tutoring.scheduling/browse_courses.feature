Feature: Browse courses
  As Miss Hehe
  I want to browse all courses
  so that I can check if there are some errors

  Scenario: Can the courses be browsed in a sort order
    Given three courses have been created
    When browse the courses in the order of their names
    Then the three courses should be listed by their names

