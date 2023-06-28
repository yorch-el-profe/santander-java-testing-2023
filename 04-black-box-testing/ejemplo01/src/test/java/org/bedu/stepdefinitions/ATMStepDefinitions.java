package org.bedu.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.bedu.ATM;
import org.bedu.exception.InvalidPinException;
import org.bedu.exception.InvalidWithdrawException;
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
  private long userAmount;

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

  @And("withdraw {long} MXN")
  public void withdraw(long amount) {
    userAmount = amount;
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

  @Then("the system should throw an error because there isn't enough money")
  public void notEnoughMoney() {
    atm.validatePin(userPin);
    assertThrows(InvalidWithdrawException.class, () -> atm.withdraw(userAmount));
  }

  @Then("the card should have {long} MXN")
  public void withdrawSuccessful(long amount) {
    atm.validatePin(userPin);
    atm.withdraw(userAmount);
    assertEquals(card.getAmount(), amount);
  }
}
