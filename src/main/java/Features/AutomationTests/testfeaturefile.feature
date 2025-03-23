Feature: Login to modules

Scenario: Verify that 'Name' matches 'Full Name (OCR)' in a Single Session
  Given I goto Sessions as Bob
  And I extract the 1. Session data
  And I click on the 1. Session
  Then The Session row values should match with values on the Single Session Page