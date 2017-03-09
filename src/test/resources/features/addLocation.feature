@bvt @smoke @uat
Feature: AddLocation

  @positive
  Scenario Outline: Add Locations to the Lab Client Quest

    Given User should be login to the lab

    Given Lab Client should be available
    When Click on the Lab Client 'Quest'
    Then Update Lab Client page should be displayed

    When Click on the location Icon
    Then Add Lab Location page should be displayed

    When Enter Location Name as <location> and enter the remaining details and click on 'Submit'
    Then Added location should be added to the location list

    Examples:
      | location    |
      | QAmeerpet   |
      | QBegumpet   |
      | QChadarghat |


