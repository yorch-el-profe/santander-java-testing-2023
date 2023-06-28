package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.bedu.exception.InvalidPinException;
import org.bedu.exception.InvalidWithdrawException;
import org.bedu.model.Card;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ATMTest {

  private static ATM atm;
  private Card card;

  @BeforeAll
  public static void init() {
    atm = new ATM();
  }

  @BeforeEach
  public void setup() {
    card = new Card(1000, "1234");
    atm.insertCard(card);
  }

  @Test
  public void validatePin() {
    assertThrows(InvalidPinException.class, () -> atm.validatePin("1235"));
  }

  @Test
  public void updatePin() {
    atm.updatePin("0000");
    assertEquals(card.getPin(), "0000");
  }

  @Test
  public void withdrawException() {
    assertThrows(InvalidWithdrawException.class, () -> atm.withdraw(2000));
  }

  @Test
  public void withdrawSuccessful() {
    atm.withdraw(200);
    assertEquals(card.getAmount(), 800);
  }
}
