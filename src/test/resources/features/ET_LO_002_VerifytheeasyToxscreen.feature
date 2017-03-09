@uat @smoke @bvt
Feature: Verify Locked Lab

  @positive
  Scenario: ET_LO_002_VerifytheeasyToxscreen
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   When Click on "Lab List" on the menu
   Then  Lab List results screen should be displayed
