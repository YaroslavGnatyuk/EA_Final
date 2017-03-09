Feature: Insurance Company

  @tag1
  Scenario: ET_002_Insurance Company_Update
  
    Given the user is on home screen
    When Select settings and choose Insurance Company
    Then Insurance Company List screen is displayed
    
    When Click Edit icon for a Insurance Company.
    Then Update Insurance Company page should be displayed
    When Make changes in the screen and click Submit.
    Then  Changes shuld be saved successfully.
    When Click plus icon against the insurance company.
    Then Changes should be reflected appropriately.
