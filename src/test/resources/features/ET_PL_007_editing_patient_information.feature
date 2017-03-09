@uat @smoke @bvt
Feature: Patient Page

  @positive
  Scenario: Editing patient information
    Given the user is on home screen
    When Click on Library icon and click on the Patient
    Then Patient List  page should be displayed   
    
    When click on Edit icon under Action column
	Then "Update Patient" window should be displayed
	