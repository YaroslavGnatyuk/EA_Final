@uat @smoke @bvt
Feature: Verify Locked Lab

  @positive
  Scenario: ET_LO_003_Updating_Lab_Info
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Click on lab name
    Then "Update Lab" screen should be displayed
   