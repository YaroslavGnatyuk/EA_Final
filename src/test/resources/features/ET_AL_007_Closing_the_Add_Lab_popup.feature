@uat @smoke @bvt
Feature: Creation of New Lab

  @positive
  Scenario: ET_AL_007_Closing_the_Add_Lab_popup
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   When Click on "+" icon beside the Search Box
   Then Click on "Close" button
   Then "Add Lab" popup should be closed and the user should be navigate to Lab List Screen
 