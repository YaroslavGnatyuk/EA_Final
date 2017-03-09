@uat @smoke @bvt
Feature: Updating the Lab Info

  @positive
  Scenario: ET_UL_005_Lab_details_modification_with_valid_values
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   When Click on lab name
   Then "Update Lab" screen should be displayed
   When Check the fields on the "Update Lab" screen
   Then The lab information is displayed
   When Change the values in the lab info fields and click update
   Then Lab info should be updated successfully
  
 