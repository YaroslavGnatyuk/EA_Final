Feature: Compound Library

@tag6
  Scenario: Click on Edit under Action Column
    Given the user is Compound Library page
    When clicked on Edit button under Action column
    Then Edit Compound popup should be displayed
    
    Given the user is Compound Library page one
    When clicked on Edit under Actions column and Edit Compound popup is displayed
    Then user should be able to edit the data
    
    Given the user is Compound Library page two
    When Edit Compound popup is displayed and user can edit the data and click on submit
    Then user should be able to submit the data and the edited compound should be displayed on the list
    
    Given the user is Compound Library page three
    When Edit Compound popup is displayed and the user clicks on Close button
    Then the popup should be closed and the user should land on the Compound Library page one
    
    Given the user is Compound Library page four
    When Edit Compound popup is displayed and the user clicks on x button
    Then the popup should be closed and the user should land on the Compound Library page.