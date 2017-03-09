@uat @smoke @bvt
Feature: Creation of New Lab

  @positive
  Scenario: ET_AL_006_Adding_Contact_information
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   When Enter all the values in the following fields
  Then Click on "+" contact icon  Add the values to Contact info fields
  Then Contact Info fields should be populated and  user should able to add the values or hide the fields to clicking on "-;" icon
