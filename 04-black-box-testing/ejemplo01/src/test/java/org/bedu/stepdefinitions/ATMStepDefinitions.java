package org.bedu.stepdefinitions;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.bedu.ATM;
import org.bedu.exception.InvalidPinException;
import org.bedu.model.Card;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ATMStepDefinitions {

  private static ATM atm;
  private Card card;
  private String userPin;

  @BeforeAll
  public static void setup() {
    atm = new ATM();
  }

  @Given("a card with {long} MXN and PIN {string}")
  public void createCard(long amount, String pin) {
    card = new Card(amount, pin);
  }

  @When("the user inserts the card")
  public void insertCard() {
    atm.insertCard(card);
  }

  @And("enters the PIN {string}")
  public void enterPin(String pin) {
    userPin = pin;
  }

  @Then("the system should throw an error because PIN is incorrect")
  public void incorrectPin() {
    assertThrows(InvalidPinException.class,
        () -> atm.validatePin(userPin));
  }

  @Then("the system should display a message of correct pin")
  public void correctPin() {
    assertTrue(atm.validatePin(userPin));
  }
}
