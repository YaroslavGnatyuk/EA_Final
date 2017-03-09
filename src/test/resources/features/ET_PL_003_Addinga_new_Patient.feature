@uat @smoke @bvt
Feature: Verify the Search Results in Patient List Page

  @positive
  Scenario: Adding a new patient to 
    Given the user is on home screen
    When Click on Library icon and click on the Patient
    Then Patient List  page should be displayed   
    
    When Click on "+;" icon beside the Search Box
	Then "Add Patient;" screen should be displayed 
    

    
   