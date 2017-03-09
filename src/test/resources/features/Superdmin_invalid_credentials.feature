@uat @smoke @bvt
Feature: Login as superadmin

  @positive
  Scenario: Login with superadmin credentials
       Given I am on easytox login page
    When I login with superadmin user 'superadmin',pwd 'admin'
    And the username and password are NOT correct
    Then Invalid User name/password should be displayed
