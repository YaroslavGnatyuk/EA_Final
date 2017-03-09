@uat @smoke @bvt
Feature: Patient Page

  @positive
  Scenario: Verify Number of records displayed 
    Given the user is on home screen
    When Click on Library icon and click on the Patient
    Then Patient List  page should be displayed   
    
    When Click on "v;" down arrow icon on selected Sorting  column 
	Then Records should be displayed based on the asecending order of the selected  field 
	When Click on "^;" Up arrow icon on Profile Name column 
	Then Records should be displayed based on the descending order of the selected field 

    
   