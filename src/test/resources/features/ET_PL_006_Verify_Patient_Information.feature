@uat @smoke @bvt
Feature: Patient Page

  @positive
  Scenario:  Verifying for the patient information 
    Given the user is on home screen
    When Click on Library icon and click on the Patient
    Then Patient List  page should be displayed   
    
    When Click on "+;" icon beside the Patient record in the patient results list
	Then Selected patient detailed information should be displayed in a popup window
	