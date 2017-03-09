Feature: Compound Library

@tag9
  Scenario: Add Compound Screen
    Given the user is Add Compound popup
    When selected Type as Test Screen
    Then the result box should be displayed with NEG and POS options and cutoff text box should be displayed
    Given the user is Add Compound popup one
    When selected Type as  Validity Testing
    Then the result box should be displayed with NORMAL and ABNORMAL options and range drop down box should be displayed
