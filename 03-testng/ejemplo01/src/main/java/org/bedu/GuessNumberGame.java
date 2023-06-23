package org.bedu;

import java.util.Random;

public class GuessNumberGame {

  private int secretNumber;
  private int tries;

  private final int MIN_RANGE = 0;
  private final int MAX_RANGE = 10;

  public void startGame() {
    tries = 0;
    generateNumber();
  }

  public int getTries() {
    return tries;
  }

  public boolean guessNumber(int number) throws GameOverException {
    if (number == secretNumber) {
      return true;
    }

    tries++;

    if (tries == 3) {
      throw new GameOverException(); // GameOver
    }

    return false;
  }

  private void generateNumber() {
    Random random = new Random();
    secretNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
  }
}