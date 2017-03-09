Feature: Compound Library

  @tag3
  Scenario: Adding a compound
    Given the user is Compound Library page
    When clicked on '+'; button next to search box
    Then Add Compound popup should be displayed
    Given the user is Compound Library page one
    When Add Compound popup is displayed
    Then user should be able to enter the data in all the fields
    Given the user is Compound Library page two
    When Add Compound popup is displayed and user entered all the required fields and click on submit
    Then user should be able to submit the data and the added compound should be displayed on the list
    Given the user is Compound Library page three
    When Add Compound popup is displayed and user is not entered all the required fields and click on submit
    Then user should not be able to submit the data and should be displayed with the missing fields.
    Given the user is Compound Library page four
    When Add Compound popup is displayed and the user clicks on 'Close' button
    Then the popup should be closed and the user should land on the Compound Library page.
    Given the user is Compound Library page five
    When Add Compound popup is displayed and the user clicks on 'x' button
    Then the popup should be closed and the user should land on the Compound Library page one.
