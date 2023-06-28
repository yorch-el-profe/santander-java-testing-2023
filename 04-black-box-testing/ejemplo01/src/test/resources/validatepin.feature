Feature: Validate card PIN

  Scenario: Incorrect PIN
    Given a card with 1000 MXN and PIN "12345"
    When the user inserts the card
    And enters the PIN "57689"
    Then the system should throw an error because PIN is incorrect

  Scenario: Correct PIN
    Given a card with 5000 MXN and PIN "00000"
    When the user inserts the card
    And enters the PIN "00000"
    Then the system should display a message of correct pin