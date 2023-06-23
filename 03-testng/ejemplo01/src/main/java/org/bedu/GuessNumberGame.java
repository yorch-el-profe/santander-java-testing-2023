package org.bedu;

public class GuessNumberGame {

  private IRandomNumberGenerator generator;
  private int secretNumber;
  private int tries;

  public GuessNumberGame(IRandomNumberGenerator generator) {
    this.generator = generator;
  }

  public void startGame() {
    tries = 0;
    secretNumber = generator.generateRandomNumber();
  }

  public int getTries() {
    return tries;
  }

  public boolean guessNumber(int number) throws GameOverException, OutOfRangeException {
    if (number > generator.getMaxRange() || number < generator.getMinRange()) {
      throw new OutOfRangeException();
    }

    if (number == secretNumber) {
      return true;
    }

    tries++;

    if (tries == 3) {
      throw new GameOverException(); // GameOver
    }

    return false;
  }
}