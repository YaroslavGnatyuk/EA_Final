@bvt @smoke @uat
Feature: Verify lab user list

@positive
Scenario: Validating enabled disabled access a for lab users

Given Enter valid Username and Password click on 'Login' button LA
When Click 'Disable User' icon for any existing user under Enable/ Disable column 
Then User should be disabled and 'User disabled successfully' message should be populated 

When Logout and attempt logging in with the above lab user credentials
Then Account disabled message should be populated and user should not be able to login to application LUL

When Select a user which is disabled and click 'Enable' icon under Enabled column
Then User account should be enabled and 'User enabled successfully' message should be populated

When Logout and attempt logging in with the above lab user credentials
Then User login should be successful