@bvt @smoke @uat
Feature: Verify the search results

@positive 
Scenario: Verify the search results

Given User should be login to the lab
When Enter any search criteria and click on search icon CL	
Then Matching records with entered data should be displayed in the case list CL

When Verify keyword search by entering Case Accession#/Patient First or last name/ Date of Birth/ or with case status of "Preocessing or finalized" CL
Then Matching records with entered data should be displayed in the case list CL