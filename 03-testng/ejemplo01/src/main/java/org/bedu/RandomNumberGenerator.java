package org.bedu;

import java.util.Random;

public class RandomNumberGenerator implements IRandomNumberGenerator {

  private final int MIN_RANGE = 0;
  private final int MAX_RANGE = 10;

  public int generateRandomNumber() {
    Random random = new Random();
    return random.nextInt(MAX_RANGE - MIN_RANGE + 1);
  }

  public int getMinRange() {
    return MIN_RANGE;
  }

  public int getMaxRange() {
    return MAX_RANGE;
  }
}
