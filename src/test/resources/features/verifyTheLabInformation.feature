@bvt @smoke @uat
Feature: Verifing lab client list

@positive
Scenario: Verify the lab information

Given Enter valid Username and Password click on 'Login' button LA
When Click on '+' icon against the lab client record in results list
Then Existing Lab Client Following values should be populated: Address: Address1,address2 Lab: LabTest