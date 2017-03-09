@uat @smoke @bvt
Feature: Updating the Lab Info

  @positive
  Scenario: ET_UL_002_VerifytheeasyToxscreen
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   When Click on "Lab List" on the menu
   Then  Lab List results screen should be displayed
