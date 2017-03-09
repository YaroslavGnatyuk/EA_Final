@uat @smoke @bvt
Feature: Insurance Company

  @positive
  Scenario: Insurance Company_Sorting data
    Given the user is on home screen
    When Select settings and choose Insurance Company
    Then Insurance Company List screen is displayed
    
    When Click on "v" down arrow icon on  Sorting  column one
    Then Records should be displayed based on the asecending order of the selected  field one
    
       When Click on "^"  Up arrow icon  on sorting column five one
    Then Records should be displayed based on the descending order of the selected field five two
    
    
     When Click on  "^" Up arrow icon  on sorting column one one
    Then Records should be displayed based on the descending order of the selected field one one
    
    When Click on "v"  down arrow icon on  Sorting  column two
    Then Records should be displayed based on the asecending order of the selected  field two 
    
    
     When Click on  "^" Up arrow icon  on sorting column two two
    Then Records should be displayed based on the descending order of the selected field two two
    
    When Click on "v" down arrow icon on  Sorting  column three
    Then Records should be displayed based on the asecending order of the selected  field three
    
    
     When Click on  "^" Up arrow icon  on sorting column three three
    Then Records should be displayed based on the descending order of the selected field thee
    
    When Click on "v"  down arrow icon on  Sorting  column four
    Then Records should be displayed based on the asecending order of the selected  field four
    
    
     When Click on "^"  Up arrow icon  on sorting column four four
    Then Records should be displayed based on the descending order of the selected field foo
    
    When Click on "v" down arrow icon on  Sorting  column five
    Then Records should be displayed based on the asecending order of the selected  field five 
    
    
    
    When Click on "^"  Up arrow icon  on sorting column six
    Then Records should be displayed based on the descending order of the selected field sooo
    
    When Click on "v" down arrow icon on  Sorting  column six six
    Then Records should be displayed based on the asecending order of the selected  field five six
    
    
    
  
    
   

