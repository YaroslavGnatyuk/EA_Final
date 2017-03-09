@uat @smoke @bvt
Feature: Verifying the Lab List

  @positive
  Scenario: Verify the Search Results
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
		
		When Enter any search criteria and click on search icon
		Then Matching records with entered data should be displayed in the Lab list
    