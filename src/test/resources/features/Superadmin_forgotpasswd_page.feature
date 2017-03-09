@uat @smoke @bvt
Feature: Login as superadmin

  @positive
  Scenario: Login with superadmin credentials
   Given I am on easytox login page
    When I press forgot password click here
    Then forgot password page for username and email should be displayed