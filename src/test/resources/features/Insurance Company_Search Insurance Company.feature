@uat @smoke @bvt
Feature: Insurance Company

  @positive
  Scenario: Insurance Company_Search Insurance Company
    Given the user is on home screen
    When Select settings and choose Insurance Company
    Then Insurance Company List screen is displayed
    When Enter any search criteria Search and click on search icon
    Then Matching records with entered data should be displayed in the Insurance Company List
    
   

