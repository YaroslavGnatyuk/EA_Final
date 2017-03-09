@uat @smoke @bvt
Feature: Verifying the Lab List

  @positive
  Scenario: ET_LI_004_Verify adding a new Lab
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
		
		When Click on "+;" icon beside the Search Box
		Then "Add Lab;" window should be displayed
    