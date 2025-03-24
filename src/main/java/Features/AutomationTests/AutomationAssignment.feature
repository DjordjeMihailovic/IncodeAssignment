Feature: Automation Assignment Test Cases

Scenario: Verify that 'Name' matches 'Full Name (OCR)' in a Single Session
  Given I goto Sessions as Bob
  And I extract the 1. Session data
  And I click on the 1. Session
  # I tried to verify all the fields that I could
  Then The Session row values should match with values on the Single Session Page

  Scenario: Verify that Adding face to Database adds it to the Identity Page
    Given I goto Sessions as Bob
    And I extract the 1. Session data
    And I click on the 1. Session
    # And I make sure that the Face is added to Database
    And I save the "Full Name (OCR)" field value of the User in Single Session Page
    And I navigate to Identities
    Then Newly Added Users "NAME" is present on the Identities Page