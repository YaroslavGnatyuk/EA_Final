@uat @smoke @bvt
Feature: Patient Page

  @positive
  Scenario: Verify the Insurance Details under Action Column
    Given the user is on home screen
    When Click on Library icon and click on the Patient
    Then Patient List  page should be displayed   
    
    When Click on umberella Sign under action column
	Then "Insurance Details" screen should be popup
	