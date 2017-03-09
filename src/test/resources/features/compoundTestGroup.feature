@bvt @smoke @uat
Feature: Compound Test Group


  Scenario: Search Box

    Given the user is Compound Test Group page
    When entered some text in the Search box
    Then user should be able to view the search results

  Scenario: Adding a test code

    Given the user is Compound Test Group page
    When clicked on ‘+’ button next to search box
    Then Add Test Code popup should be displayed

    Given the user is Compound Test Group page
    When Add Test Code popup is displayed
    Then user should be able to enter the data in all the fields

    Given the user is Compound Test Group page
    When Add Test Code popup is displayed and user entered all the required fields and click on submit
    Then user should be able to submit the data and the added Test code should be displayed on the list

    Given the user is Compound Test Group page
    When Add Test Code popup is displayed and user is not entered all the required fields and click on submit
    Then user should not be able to submit the data and should be displayed with the required fields.

    Given the user is Compound Test Group page
    When Add Test Code popup is displayed and the user clicks on ‘Close’ button
    Then the popup should be closed and the user should land on the Compound Test Group page.

    Given the user is Compound Test Group page
    When Add Test Code popup is displayed and the user clicks on ‘x’ button
    Then the popup should be closed and the user should land on the Compound Test Group page.

  Scenario Outline: No of records to be displayed on the page

    Given the user is Compound Test Group page
    When clicked on dropdown that shows <number> to be displayed on the page
    Then user should be able to view and select the options from the list and the corresponding <number> of records should be displayed on the page.
    Examples:
      | number |
      | 10     |
      | 20     |
      | 50     |
      | 100    |
      | All    |

  Scenario: Checking the sorting order of the displayed results

    Given the user is Compound Test Group page
    When clicked on Test Code column of the list
    Then the list should be displayed in the alphabetical order

    Given the user is Compound Test Group page
    When clicked on Description column of the list
    Then the list should be displayed in the alphabetical order

    Given the user is Compound Test Group page
    When clicked on Compounds column of the list
    Then the list should be displayed in the alphabetical order

  Scenario: Click on Edit under Action Column

    Given the user is Compound Test Group page
    When clicked on Edit button under Action column
    Then “Edit Test Code” popup should be displayed

    Given the user is Compound Test Group page
    When clicked on Edit under Actions column and Edit Test Code popup is displayed
    Then user should be able to edit the data

    Given the user is Compound Test Group page
    When Edit Test Code popup is displayed and user can edit the data and click on update button
    Then user should be able to update the data and the edited Test Code should be displayed on the list

    Given the user is Compound Test Group page
    When Edit Test Code popup is displayed and the user clicks on ‘Close’ button
    Then the popup should be closed and the user should land on the Compound Test Group page.

    Given the user is Compound Test Group page
    When Edit Test Code popup is displayed and the user clicks on ‘x’ button
    Then the popup should be closed and the user should land on the Compound Test Group page.

  Scenario: Navigating to the next and previous pages

    Given the user is Compound Test Group page
    When clicked on next button
    Then the user should be able to navigate to the next page

    Given the user is Compound Test Group page
    When clicked on Prev button
    Then the user should be able to navigate to the Previous page

  Scenario: Checking the message of no of results displayed on current page

    Given the user is Compound Test Group page
    When the user searches the results
    Then the text “Showing x to y of z entries” should be displayed on the bottom left corner of the list.


  Scenario: Buttons on the Compound Test Group page

    Given the user is Compound Test Group page
    When clicked on maximize button
    Then the screen should be maximized

    Given the user is Compound Test Group page
    When the screen is maximized and clicked on minimize button
    Then the screen should be displayed in normal mode

    Given the user is Compound Test Group page
    When clicked on ‘-‘ button
    Then the list should be hidden

    Given the user is Compound Test Group page
    When the list is hidden and clicked on ‘+‘ button
    Then the list should be shown

    Given the user is Compound Test Group page
    When the list is hidden and clicked on ‘x‘ button
    Then the list should be closed
