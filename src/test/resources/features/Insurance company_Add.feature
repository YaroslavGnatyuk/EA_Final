Feature: Insurance Company

  @tag1
  Scenario: Insurance_Company_Add
    Given the user is on home screen
    When Select settings and choose Insurance Company
    Then Insurance Company List screen is displayed
    When Click Add Insurance Company plus icon.
    Then Add Insurance Company  page should be displayed
    When Enter all the information in the screen and click Submit.
    Then A new insurance company should be created successfully.
    When Click plus icon against the new insurance company.
    Then All the values should be populated correctly as per entered data.

