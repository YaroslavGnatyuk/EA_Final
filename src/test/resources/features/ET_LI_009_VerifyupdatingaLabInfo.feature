@uat @smoke @bvt
Feature: Verifying the Lab List

  @positive
  Scenario: ET_LI_009_Verify updating a Lab Info
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Click on Lab record under Lab Name
    Then "Update Lab Info" screen should be displayed
     When Make changes as needed and click update.
    Then Lab info is updated successfully.
