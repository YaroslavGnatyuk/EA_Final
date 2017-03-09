@uat @smoke @bvt
Feature: Testing Profile

  @positive
  Scenario: TestingProfile Adding A NewProfile
    Given the user is on home screen
    When Click on Library Icon and Select the Testing Profile
    Then Testing Profile page should be open     
    
    When Click on "+;" icon beside the Search Box
    Then Add Profile screen should be displayed

    
      