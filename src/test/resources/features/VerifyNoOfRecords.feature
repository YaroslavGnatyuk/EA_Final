@bvt @smoke @uat
Feature: Verify number of records

@positive
Scenario: Verify number of records

Given User should be login to the lab
When Verify the default number of records displayed OL
Then Deafult number '10' should be displayed in the dropdown box OL

When Click on the dropdown that shows no of records to be displayed on the page OL
Then User should be able to view and select the options from the list and the corresponding number of records should be diplayed on the page OL