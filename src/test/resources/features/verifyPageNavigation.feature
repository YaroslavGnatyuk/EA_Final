@bvt @smoke @uat
Feature: Verify Page Navigation

@positive
Scenario: Verify Page Navigation

Given User should be login to the lab
When Select Settings -> User
Then User List screen with list of users is displayed

When Navigate back and forth by selecting page numbers "Prev/1,2,3/Next" LU
Then User should be navigate to the selected page LU

When Checking the message of no of records displayed on the current page bottom left corner of the screen LU
Then A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the list LU