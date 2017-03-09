@uat @smoke @bvt
Feature: Testing Profile

  @positive
  Scenario: TestProfile Search Results
    Given the user is on home screen
    When Click on Library Icon and Select the Testing Profile
    Then Testing Profile page should be open     
    
    When Enter any search criteria and click on search icon
    Then Matching records with entered data should be displayed in the Test Profile

    
   