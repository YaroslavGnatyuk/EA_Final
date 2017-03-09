@uat @smoke @bvt
Feature: Verify Locked Lab

  @positive
  Scenario: ET_LO_004_Verify_the_Lock_Lab
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
    When Click on lab User List name
    Then Lab User  screen should be displayed
   When Click "Lock" icon for that existing lab on right corner of the screen
   Then Lab should be locked and "Lab Locked Successfully" message should be populated
   When Logout and attempt logging in with the above lab credentials
   Then Account locked message should be populated and Lab should not be able to login to application
   When Select a lab which is locked and click "Unlock" icon
   Then Lab account should be unlocked and "Lab unlocked successfully" message should be populated
   When Logout and attempt logging in with the above lab credentials one
   Then Lab login should be successful.
   
   