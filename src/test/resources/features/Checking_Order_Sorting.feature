Feature: Compound Library

 @tag5
  Scenario: Checking the sorting order of the displayed results
    Given the user is Compound Library page
    When clicked on Class column of the list
    Then the list should be displayed in the alphabetical order
    Given the user is Compound Library page one
    When clicked on Type column of the list
    Then the list should be displayed in the alphabetical order one
    Given the user is Compound Library page two
    When clicked on Name column of the list
    Then the list should be displayed in the alphabetical order two
    Given the user is Compound Library page three
    When clicked on Result column of the list
    Then the list should be displayed in the alphabetical order three
    Given the user is Compound Library page four
    When clicked on Range column of the list
    Then the list should be displayed in the numerical order
    Given the user is Compound Library page five
    When clicked on Cut off column of the list
    Then the list should be displayed in the numerical order five
    Given the user is Compound Library page six
    When clicked on Positive Comments column of the list
    Then the list should be displayed in the alphabetical order six
    Given the user is Compound Library page seven		
    When clicked on Negative Comments column of the list
    Then the list should be displayed in the alphabetical order seven
    Given the user is Compound Library page ei
    When clicked on billing code column of the list
    Then the list should be displayed in the numerical order ei
    Given the user is Compound Library page ni
    When clicked on Oral detection column of the list
    Then the list should be displayed in the alphabetical order ni
    Given the user is Compound Library page ten
    When clicked on Urine detection column of the list
    Then the list should be displayed in the alphabetical order ten