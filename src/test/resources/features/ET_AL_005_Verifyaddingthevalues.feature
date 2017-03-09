@uat @smoke @bvt
Feature: Creation of New Lab

  @positive
  Scenario: ET_AL_005_Verifyaddingthevalues
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   When Enter all the values in the following fields
   Then  Lab details should be added to "Lab List" successfully.
