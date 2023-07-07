package org.bedu;

import java.util.HashMap;
import java.util.Map;

import org.bedu.exception.InvalidRomanNumeralException;

public class RomanNumerals {
  private final Map<Character, Integer> numerals;

  public RomanNumerals() {
    numerals = new HashMap<>();

    numerals.put('I', 1);
    numerals.put('V', 5);
    numerals.put('X', 10);
    numerals.put('L', 50);
    numerals.put('C', 100);
    numerals.put('D', 500);
    numerals.put('M', 1000);
  }

  public int toDecimal(final String input) {
    final String roman = input.toUpperCase();

    int current = 0;
    int previous = 0;

    for (int i = 0; i < roman.length(); i++) {
      final char currentRoman = roman.charAt(i);

      if (!numerals.containsKey(currentRoman)) {
        throw new InvalidRomanNumeralException();
      }

      final int temp = numerals.get(roman.charAt(i));

      if (temp < previous) {
        current -= temp;
      } else {
        current += temp;
      }

      previous = temp;
    }

    return current;
  }
}