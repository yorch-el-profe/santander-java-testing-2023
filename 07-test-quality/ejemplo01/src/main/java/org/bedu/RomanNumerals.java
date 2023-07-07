package org.bedu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.bedu.exception.InvalidRomanNumeralException;

public class RomanNumerals {

  private static String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
  private static Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

  private Map<Character, Integer> numerals;

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

  public int toDecimal(String input) {
    String roman = input.toUpperCase();

    int current = 0;
    int previous = 0;

    for (int i = 0; i < roman.length(); i++) {
      char currentRoman = roman.charAt(i);

      if (!numerals.containsKey(currentRoman)) {
        throw new InvalidRomanNumeralException();
      }

      int temp = numerals.get(roman.charAt(i));

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