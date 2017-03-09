@tag
Feature: Compound Library

  @tag1
  Scenario: Choose File
    Given the user is on Compound Library page
    When the user clicked on Choose file
    Then upload popup to select the files should be displayed
    Given the user is Compound Library page
    When the user selected the required file to upload
    Then the selected file name should be displayed next to the Choose file
    Given the user is Compound Library page
    When the user selected the required file to upload and click on upload
    Then the selected file should be uploaded and data should be loaded    under compounds table

  @tag2
  Scenario: Search Box
    Given the user is Compound Library page
    When entered some text in the Search box
    Then user should be able to view the search results

  @tag3
  Scenario: Adding a compound
    Given the user is Compound Library page
    When clicked on ‘+’ button next to search box
    Then Add Compound popup should be displayed
    Given the user is Compound Library page
    When Add Compound popup is displayed
    Then user should be able to enter the data in all the fields
    Given the user is Compound Library page
    When Add Compound popup is displayed and user entered all the required fields and click on submit
    Then user should be able to submit the data and the added compound should be displayed on the list
    Given the user is Compound Library page
    When Add Compound popup is displayed and user is not entered all the required fields and click on submit
    Then user should not be able to submit the data and should be displayed with the missing fields.
    Given the user is Compound Library page
    When Add Compound popup is displayed and the user clicks on ‘Close’ button
    Then the popup should be closed and the user should land on the Compound Library page.
    Given the user is Compound Library page
    When Add Compound popup is displayed and the user clicks on ‘x’ button
    Then the popup should be closed and the user should land on the Compound Library page.

  @tag4
  Scenario: No of records to be displayed on the page
    Given the user is Compound Library page
    When clicked on dropdown that shows no of records to be displayed on the page
    Then user should be able to view and select the options from the list and the corresponding number of records should be displayed on the page.

  @tag5
  Scenario: Checking the sorting order of the displayed results
    Given the user is Compound Library page
    When clicked on Class column of the list
    Then the list should be displayed in the alphabetical order
    Given the user is Compound Library page
    When clicked on Type column of the list
    Then the list should be displayed in the alphabetical order
    Given the user is Compound Library page
    When clicked on Name column of the list
    Then the list should be displayed in the alphabetical order
    Given the user is Compound Library page
    When clicked on Result column of the list
    Then the list should be displayed in the alphabetical order
    Given the user is Compound Library page
    When clicked on Range column of the list
    Then the list should be displayed in the numerical order
    Given the user is Compound Library page
    When clicked on Cut off column of the list
    Then the list should be displayed in the numerical order
    Given the user is Compound Library page
    When clicked on Positive Comments column of the list
    Then the list should be displayed in the alphabetical order
    Given the user is Compound Library page
    When clicked on Negative Comments column of the list
    Then the list should be displayed in the alphabetical order
    Given the user is Compound Library page
    When clicked on billing code column of the list
    Then the list should be displayed in the numerical order
    Given the user is Compound Library page
    When clicked on Oral detection column of the list
    Then the list should be displayed in the alphabetical order
    Given the user is Compound Library page
    When clicked on Urine detection column of the list
    Then the list should be displayed in the alphabetical order

  @tag6
  Scenario: Click on Edit under Action Column
    Given the user is Compound Library page
    When clicked on Edit button under Action column
    Then “Edit Compound” popup should be displayed
    Given the user is Compound Library page
    When clicked on Edit under Actions column and Edit Compound popup is displayed
    Then user should be able to edit the data
    Given the user is Compound Library page
    When Edit Compound popup is displayed and user can edit the data and click on submit
    Then user should be able to submit the data and the edited compound should be displayed on the list
    Given the user is Compound Library page
    When Edit Compound popup is displayed and the user clicks on ‘Close’ button
    Then the popup should be closed and the user should land on the Compound Library page.
    Given the user is Compound Library page
    When Edit Compound popup is displayed and the user clicks on ‘x’ button
    Then the popup should be closed and the user should land on the Compound Library page.

  @tag7
  Scenario: Navigating to the next and previous pages
    Given the user is Compound Library page
    When clicked on next button
    Then the user should be able to navigate to the next page
    Given the user is Compound Library page
    When clicked on Prev button
    Then the user should be able to navigate to the Previous page

  @tag8
  Scenario: Checking the message of no of results displayed on current page
    Given the user is Compound Library page
    When the user searches the results
    Then the text “Showing x to y of z entries” should be displayed on the bottom left corner of the list.

  @tag9
  Scenario: Add Compound Screen
    Given the user is Add Compound popup
    When selected Type as Test Screen
    Then the result box should be displayed with “NEG” and “POS” options and “cutoff” text box should be displayed
    Given the user is Add Compound popup
    When selected Type as Validity Testing
    Then the result box should be displayed with “NORMAL” and “ABNORMAL” options and “range” drop down box should be displayed
