@bvt @smoke @uat
Feature: Verify the data sorting

@positive
Scenario: Verify the data sorting

Given User should be login to the lab
When Click on '˅' down arrow icon on sorting column PR
Then Records should be displayed based on the asecending order of the selected sorting column PR

When Click on '^' Up icon arrow on Profile Name column PR
Then Records should be displayed based on the descending order of the selected sorting column PR