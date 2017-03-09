Feature: Insurance Company

  @tag3
  Scenario: Insurance Company_Delete
  
    Given the user is on home screen
    When Select settings and choose Insurance Company
    Then Insurance Company List screen is displayed
    
    When Click Edit icon for a Insurance Company.
    Then Update Insurance Company page should be displayed
   
    When Click Delete button
    Then  Confirmation message is displayed
   
    When Click No on confirmation message
    Then Insurance Company should not be deleted
    
    When Click Delete button and Yes on confirmation message
    Then Insurance Company should be deleted successfully
