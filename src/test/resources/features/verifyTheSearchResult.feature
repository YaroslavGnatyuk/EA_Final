@bvt @smoke @uat
Feature: Verify the search results

@positive
Scenario: Verify the search results

Given User should be login to the lab
When Enter any search criteria and click on search icon I
Then Matching records with entered data should be displayed in the Instruments list I
