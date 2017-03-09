@uat @smoke @bvt
Feature: Verify the Search Results in Patient List Page

  @positive
  Scenario: Verify the Search Results
    Given the user is on home screen
    When Click on Library icon and click on the Patient
    Then Patient List  page should be displayed   
    
    When Enter any search criteria and click on search icon
	Then Matching records with entered data should be displayed in the patient list  
    

    
   