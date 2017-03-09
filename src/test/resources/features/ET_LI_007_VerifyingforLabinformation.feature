@uat @smoke @bvt
Feature: Verifying the Lab List

  @positive
  Scenario: ET_LI_007_Verifying for Lab information
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Click on "+;" icon against the lab record in results list
    Then respected values should be populated such as created and modified users details
   
