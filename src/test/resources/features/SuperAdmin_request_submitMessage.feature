@uat @smoke @bvt
Feature: Login as superadmin

  @positive
  Scenario: Login with superadmin credentials
   Given I am on easytox login page
    When I press forgot password click here
    And  I enter username and email id
    Then forgot password request submitted message should be displayed