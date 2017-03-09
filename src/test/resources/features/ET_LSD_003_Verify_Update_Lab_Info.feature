@uat @smoke @bvt
Feature: Verify Lab subscription details

  @positive
  Scenario: ET_LSD_003_Verify_Update_Lab_Info
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Click on lab name
    Then "Update Lab" screen should be displayed
   
   
   