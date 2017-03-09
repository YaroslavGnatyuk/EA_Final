@uat @smoke @bvt
Feature: Login as superadmin

  @positive
  Scenario: Login with superadmin credentials
    Given I am on easytox login page
    When I login with superadmin user 'superadmin',pwd 'admin'
    And the username and password are NOT correct
    And I make 3 unsuccessful login attempts
    Then 'superadmin' user should be locked 
    And userid locked due to maximum unsuccessful attempts should be displayed.