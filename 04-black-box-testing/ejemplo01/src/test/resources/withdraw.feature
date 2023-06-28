Feature: Withdraw

  Scenario: Amount higher
    Given a card with 200 MXN and PIN "12345"
    When the user inserts the card
    And enters the PIN "12345"
    And withdraw 500 MXN
    Then the system should throw an error because there isn't enough money

  Scenario: Successful withdraw
    Given a card with 3000 MXN and PIN "12345"
    When the user inserts the card
    And enters the PIN "12345"
    And withdraw 800 MXN
    Then the card should have 2200 MXN