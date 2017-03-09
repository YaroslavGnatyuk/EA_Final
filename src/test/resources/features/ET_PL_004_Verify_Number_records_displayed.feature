@uat @smoke @bvt
Feature: Patient Page

  @positive
  Scenario: Verify Number of records displayed 
    Given the user is on home screen
    When Click on Library icon and click on the Patient
    Then Patient List  page should be displayed   
    
    When Verify the default number of records displayed
	Then Default number "10;" should be displayed in the dropdown box
	
	When Click on dropdown that shows no of records to be displayed on the page
	Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page
    

    
   