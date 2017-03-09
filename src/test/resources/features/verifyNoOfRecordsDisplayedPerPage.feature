@bvt @smoke @uat
Feature: Verify number of records displayed per page

@positive
Scenario: Verify number of records displayed per page

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Verify the default number of records displayed LU
Then Default number "10" should be displayed in the dropdown box LU

When Click on dropdown that shows no of records to be displayed on the page LU
Then User should be able to view and select the options from the list and the corresponding number of records should be displayed on the page LU
