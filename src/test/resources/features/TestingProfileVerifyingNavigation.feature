@uat @smoke @bvt
Feature: Testing Profile

  @positive
  Scenario: TestingProfile verifying paging
    Given the user is on home screen
    When Click on Library Icon and Select the Testing Profile
    Then Testing Profile page should be open     
    
    When Navigate back and forth by selecting page numbers
    Then  User should be navigate to the selected page

    When Checking the message of no of records displayed on the current page bottom left corner of the screen
    Then A text message Showing x to y of z entries should be displayed on the bottom left corner of the list
    