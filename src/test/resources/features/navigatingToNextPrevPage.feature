@btv @somke @uat
Feature: Navigating to the next and Previous page

@positive
Scenario: Navigating to the next and Previous pages

Given the user is on Accession Prefix page 
When clicked on next button AP
Then the user should be able to navigate to the next page AP

Given the user is on Accession Prefix page 
When clicked on Prev button AP
Then the user should be able to navigate to the Previous page AP
