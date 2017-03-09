@tag
Feature: Compound Library

  @tag1
  Scenario: Choose File
    Given the user is on Compound Library page
    When the user clicked on Choose file
    Then upload popup to select the files should be displayed
    Given the user is Compound Library page
    When the user selected the required file to upload
    Then the selected file name should be displayed next to the Choose file
    Given the user is Compound Library page
    When the user selected the required file to upload and click on upload
    Then the selected file should be uploaded and data should be loaded    under compounds table
