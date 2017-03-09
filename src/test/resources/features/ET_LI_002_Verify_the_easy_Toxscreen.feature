@uat @smoke @bvt
Feature: Verifying the Lab List

  @positive
  Scenario: Verify the easyTox screen
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
		
		When Click on "Lab List" on the menu
		Then "Lab List" screen should be displayed
    