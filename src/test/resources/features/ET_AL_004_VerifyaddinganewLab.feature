@uat @smoke @bvt
Feature: Creation of New Lab

  @positive
  Scenario: ET_AL_004_VerifyaddinganewLab
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   When Click on "+;" icon beside the Search Box
   Then  Add Lab window should be populated
