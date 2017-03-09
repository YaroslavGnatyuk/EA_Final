@uat @smoke @bvt
Feature: Updating the Lab Info

  @positive
  Scenario: ET_UL_006_Verify_the_Icons
    Given Enter valid Username and Password click on "Login" button
    Then Lab admin user should be able to login successfully
   When Click on lab name
   Then "Update Lab" screen should be displayed
   When Click on" Lock" icon on the right corner of the Update lab screen
   Then That Particular Lab is Locked message should be populated
   When Click on" User List" icon on the right corner of the Update lab screen one
   Then  "Lab User List " screen should be dispalyed
  When Click on" Subscription Details" icon on the right corner of the Update lab screen two
  Then "Subscription Details" windoe should be populated
  When Click on" User+" icon on the right corner of the Update lab screen three
  Then "Add Lab Admin User" screen should be dispalyed one
 