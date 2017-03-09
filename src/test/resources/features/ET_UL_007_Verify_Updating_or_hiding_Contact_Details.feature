@uat @smoke @bvt
Feature: Updating the Lab Info

  @positive
  Scenario: ET_UL_007_Verify_Updating_or_hiding_Contact_Details
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Click on lab name
    Then "Update Lab" screen should be displayed
    When Click on "+" icon besides the Cantact Details
    Then Contact Details fields should be updated successfully and   user can change the the values or hide the fields by clicking on "-" icon
