@uat @smoke @bvt
Feature: Verifying the Lab List

  @positive
  Scenario: ET_LI_0010_Verifythepagination
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   
    When Navigate back and forth by selecting page numbers "Prev/1,2,3/Next"
    Then User should be navigate to the selected page
     When  searches the results
    Then A text message Showing x to y of z entries should be displayed on the bottom left corner of the list.
