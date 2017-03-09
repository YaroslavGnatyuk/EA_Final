@bvt @smoke @uat
Feature: Verify lab user list

@positve
Scenario: Validating account expiration 

Given Enter valid Username and Password click on 'Login' button LA
When Click on Account not expired icon
Then 'User account expired now' message should be diplayed and icon change to check mark

When Logout and attempt logging in with the above lab user credentials
Then Account Expired message should be populated and user should not be able to login to application

When Click on Account Expired icon
Then 'User account activated now' message should be displayed and icon changed to not expired icon

When Logout and attempt logging in with the above lab user credentials
Then User login should be successful