package org.bedu;

import org.bedu.exception.InvalidPinException;
import org.bedu.exception.InvalidWithdrawException;
import org.bedu.exception.NoCardInsertedException;
import org.bedu.model.Card;

public class ATM {

  private Card card;

  public void insertCard(Card card) {
    this.card = card;
  }

  public boolean validatePin(String pin) throws InvalidPinException, NoCardInsertedException {
    if (!hasCard()) {
      throw new NoCardInsertedException();
    }

    if (!card.getPin().equals(pin)) {
      throw new InvalidPinException();
    }

    return true;
  }

  public void updatePin(String pin) throws NoCardInsertedException {
    if (!hasCard()) {
      throw new NoCardInsertedException();
    }

    card.setPin(pin);
  }

  public void withdraw(long amount) throws NoCardInsertedException, InvalidWithdrawException {
    if (!hasCard()) {
      throw new NoCardInsertedException();
    }

    if (amount > card.getAmount()) {
      throw new InvalidWithdrawException();
    }

    card.setAmount(card.getAmount() - amount);
  }

  public void exit() throws NoCardInsertedException {
    if (!hasCard()) {
      throw new NoCardInsertedException();
    }

    card = null;
  }

  private boolean hasCard() {
    return card != null;
  }
}
