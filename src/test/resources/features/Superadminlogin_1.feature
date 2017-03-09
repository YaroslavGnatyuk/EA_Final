@uat @smoke @bvt
Feature: Login as superadmin

  @positive
  Scenario: Login with superadmin credentials
    Given I am on easytox login page
    When I login with superadmin user 'superadmin' and pwd 'admin'
    And the username and password are correct
    Then the superadmin login page should be displayed
