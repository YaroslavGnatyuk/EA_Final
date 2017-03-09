@uat @smoke @bvt
Feature: Testing Profile

  @positive
  Scenario: TestingProfile verify data sorting
    Given the user is on home screen
    When Click on Library Icon and Select the Testing Profile
    Then Testing Profile page should be open     
    
    When Click on "v;" down arrowicon  on Profile Name  column
    Then Records should be displayed based on the asecending order of the Profile Name

     When Click on "^;" Up arrow icon on Profile Name column
    Then Records should be displayed based on the descending order of the selected field