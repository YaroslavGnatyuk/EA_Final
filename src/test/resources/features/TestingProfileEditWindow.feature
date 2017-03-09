@uat @smoke @bvt
Feature: Testing Profile

  @positive
  Scenario: TestingProfile Edit window display
    Given the user is on home screen
    When Click on Library Icon and Select the Testing Profile
    Then Testing Profile page should be open     
    
    When Click on Edit icon under Action column
    Then  "Edit Profile" window should be displayed
