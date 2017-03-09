Feature: Compound Library

@tag7
  Scenario: Navigating to the next and previous pages
    Given the user is Compound Library page
    When clicked on next button
    Then the user should be able to navigate to the next page
    Given the user is Compound Library page one
    When clicked on Prev button
    Then the user should be able to navigate to the Previous page