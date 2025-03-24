Feature: Automation Assignment Test Cases

  @AutomationAssignment
  Scenario: Verify that 'Name' matches 'Full Name (OCR)' in a Single Session
    Given I goto Sessions as Bob
    And I extract the Session data for id "67e12b9e060257e40e245d8d"
    And I click on the Session containing id "67e12b9e060257e40e245d8d"
    # I tried to verify all the fields that I could
    Then The Session row values should match with values on the Single Session Page

  @AutomationAssignment
  Scenario: Verify that Adding face to Database adds it to the Identity Page
    Given I goto Sessions as Bob
    And I extract the Session data for id "67e12b9e060257e40e245d8d"
    And I click on the Session containing id "67e12b9e060257e40e245d8d"
    And I make sure that the Face is added to Database
    And I save the "Full Name (OCR)" field value of the User in Single Session Page
    And I navigate to Identities
    # I went with checking the Name because I didn't upload a document with National ID; checking upon that would be preferred
    Then Newly Added Users "NAME" is present on the Identities Page

  @AutomationAssignment
  Scenario: Verify that active Flow with ID Capture, ID Validation and Face Capture is created
    Given I goto Flows as Bob
    And I create a basic flow with Modules "ID Capture, ID Validation, Face Capture"
    And I click on Save Flow
    And I do Action "Activate Flow" on my Flow
    Then My Flow should be created successfully
    # I don't like cleaning like this, clean-up module should be set separately
    And I do Action "Delete flow" on my Flow