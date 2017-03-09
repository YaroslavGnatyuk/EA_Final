@uat @smoke @bvt
Feature: Verify Lab subscription details

  @positive
  Scenario: ET_LSD_002_VerifytheeasyToxscreen
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   When Click on "Lab List" on the menu
   Then  Lab List results screen should be displayed
