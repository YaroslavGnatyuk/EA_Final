@uat @smoke @bvt
Feature: Verifying the Lab List

  @positive
  Scenario: ET_LI_005_Verify Number of records displayed
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Verify the default number of records displayed
    Then Default number "15;" should be displayed in the dropdown box
    When Click on dropdown that shows number of records to be displayed on the page
    Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page
