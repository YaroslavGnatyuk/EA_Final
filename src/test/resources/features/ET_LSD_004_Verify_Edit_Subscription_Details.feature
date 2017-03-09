@uat @smoke @bvt
Feature: Verify Lab subscription details

  @positive
  Scenario: ET_LSD_004_Verify_Edit_Subscription_Details
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Click on lab name
    Then "Update Lab" screen should be displayed
    When Click on Subscription Details icon on top right corner of the screen
    Then Subscription details window should be populated
    When Edit the Subscription Details field values and Waive off field values and click Update
    Then All the field values should be editable and updaed successfullly
   
   
   