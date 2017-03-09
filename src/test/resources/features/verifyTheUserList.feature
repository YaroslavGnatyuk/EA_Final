@bvt @smoke @uat
Feature: Verify lab user list

@positive
Scenario: Verify the user list

Given Enter valid Username and Password click on 'Login' button LA
When Click on User List icon under 'action' column	
Then Lab User List screen should be displayed
