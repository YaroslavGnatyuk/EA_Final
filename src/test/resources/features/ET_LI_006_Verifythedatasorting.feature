@uat @smoke @bvt
Feature: Verifying the Lab List

  @positive
  Scenario: ET_LI_006_Verifythedatasorting
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Click on "v;" down arrow icon on any column
    Then Records should be displayed based on the asecending order of the selected field
   When  Click on "^;"Up arrow icon on any column
   Then Records should be displayed based on the descending order of the selected field
