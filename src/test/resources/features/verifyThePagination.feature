@bvt @smoke @uat
Feature: Verify the pagination

@positive
Scenario: Verify the pagination

Given User should be login to the lab
When Navigate back and forth by selecting page numbers "Prev/1,2,3/Next" CL
Then User should be navigate to the selected page CL

When Checking the message of no of records displayed on the current page bottom left corner of the screen CL
Then A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the list CL