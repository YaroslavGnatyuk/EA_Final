@bvt @smoke @uat
Feature: Validity Test Group


  Scenario: Search Box

    Given the user is Validity Test Group page
    When entered some text in the Search box in Validity Test Group page
    Then user should be able to view the search results on page


  Scenario: Adding a Drug

    Given the user is Validity Test Group page
    When clicked on ‘+’ button next to search box in Validity Test Group page
    Then Add Validity Test Code popup should be displayed

    Given the user is Validity Test Group page
    When Add Validity Test Code popup is displayed
    Then user should be able to enter the data in the fields

    Given the user is Validity Test Group page
    When Add Validity Test Code popup is displayed and user entered all the required fields and click on submit
    Then user should be able to submit the data and the added test code should be displayed on the list

    Given the user is Validity Test Group page
    When Add Validity Test Code popup is displayed and user is not entered all the required fields and click on submit
    Then user should be not be able to submit the data and the missing fields should be displayed with red color

    Given the user is Validity Test Group page
    When Add Validity Test Code popup is displayed and the user clicks on ‘Close’ button
    Then the popup should be closed and the user should land on the Validity Test Group page

    Given the user is Validity Test Group page
    When Add Validity Test Code popup is displayed and the user clicks on ‘x’ button
    Then the popup should be closed and the user should land on the Validity Test Group page


  Scenario Outline: No of records to be displayed on the page

    Given the user is Validity Test Group page
    When clicked on dropdown that shows <number> to be displayed on the Validity Test Group page
    Then user should be able to view and select the options from the list and the corresponding <number> of records should be displayed on the Validity Test Group page.
    Examples:
      | number |
      | 10     |
      | 25     |
      | 50     |
      | 100    |
      | All    |

  Scenario: Checking the sorting order of the displayed results

    Given the user is Validity Test Group page
    When clicked on Validity Test Code column of the list
    Then the list should be displayed in the alphabetical order on the Validity Test Group page

    Given the user is Validity Test Group page
    When clicked on Description column of the list on the Validity Test Group page
    Then the list should be displayed in the alphabetical order on the Validity Test Group page

    Given the user is Validity Test Group page
    When clicked on Compounds column of the list on the Validity Test Group page
    Then the list should be displayed in the alphabetical order on the Validity Test Group page

  Scenario: Click on Edit under Action Column

    Given the user is Validity Test Group page
    When clicked on Edit button under Action column on the Validity Test Group page
    Then “Edit Validity Test Code” popup should be displayed

    Given the user is Validity Test Group page
    When clicked on Edit under Actions column and Edit Validity Test Code is displayed
    Then user should be able to edit the data on the Validity Test Group page

    Given the user is Validity Test Group page
    When Edit Validity Test Code popup is displayed and user can edit the data and click on update button
    Then user should be able to update the data and the edited  validity Test Code should be displayed on the list

    Given the user is Validity Test Group page
    When Edit Validity Test Code popup is displayed and the user clicks on ‘Close’ button
    Then the popup should be closed and the user should land on the Validity Test Group page

    Given the user is Validity Test Group page
    When Edit Validity Test Code popup is displayed and the user clicks on ‘’x’ button
    Then the popup should be closed and the user should land on the Validity Test Group page

  Scenario: Navigating to the next and previous pages

    Given the user is Validity Test Group page
    When clicked on next button on the Validity Test Group page
    Then the user should be able to navigate to the next page on the Validity Test Group page

    Given the user is Validity Test Group page
    When clicked on Prev button on the Validity Test Group page
    Then the user should be able to navigate to the Previous page on the Validity Test Group page

  Scenario: Checking the message of no of results displayed on current page

    Given the user is Validity Test Group page
    When the user searches the results on the Validity Test Group page
    Then the text “Showing x to y of z entries” should be displayed on the bottom left corner of the list on the Validity Test Group page.

  Scenario: Buttons on the Validity Test Group page

    Given the user is Validity Test Group page
    When clicked on maximize button on the Validity Test Group page
    Then the screen should be maximized on the Validity Test Group page

    Given the user is Validity Test Group page
    When the screen is maximized and clicked on minimize button on the Validity Test Group page
    Then the screen should be displayed in normal mode on the Validity Test Group page

    Given the user is Validity Test Group page
    When clicked on ‘-‘ button on the Validity Test Group page
    Then the list should be hidden on the Validity Test Group page

    Given the user is Validity Test Group page
    When the list is hidden and clicked on ‘+‘ button on the Validity Test Group page
    Then the list should be shown on the Validity Test Group page

    Given the user is Validity Test Group page
    When the list is hidden and clicked on ‘x‘ button on the Validity Test Group page
    Then the list should be closed on the Validity Test Group page

