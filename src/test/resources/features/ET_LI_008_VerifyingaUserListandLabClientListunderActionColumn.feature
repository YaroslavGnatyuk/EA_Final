@uat @smoke @bvt
Feature: Verifying the Lab List

  @positive
  Scenario: ET_LI_008_Verifying a User List/Lab Client List under "Action" Column
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Click on user icon under Action Column
    Then User List screen should be displayed.
     When Click on list icon under Action Column
    Then Lab Client List screen should be displayed.
