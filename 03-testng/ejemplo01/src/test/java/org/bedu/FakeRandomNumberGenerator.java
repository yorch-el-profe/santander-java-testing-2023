package org.bedu;

public class FakeRandomNumberGenerator implements IRandomNumberGenerator {

  public int generateRandomNumber() {
    return 5;
  }

  public int getMinRange() {
    return 0;
  }

  public int getMaxRange() {
    return 10;
  }
}
