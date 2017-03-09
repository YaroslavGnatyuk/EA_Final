@uat @smoke @bvt
Feature: Insurance Company

  @positive
  Scenario: Insurance Company_Number of records per page
    Given the user is on home screen
    When Select settings and choose Insurance Company
    Then Insurance Company List screen is displayed
    
    When Verify the default number of records displayed
    Then Default number "10" should be displayed in the dropdown box
    
    
     When Click on dropdown that shows no of records to be displayed on the page
    Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page
    
   

