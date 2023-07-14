package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.bedu.exception.InvalidRomanNumeralException;

public class RomanNumeralsTest {

  private static RomanNumerals algorithm;

  @BeforeAll
  public static void setup() {
    algorithm = new RomanNumerals();
  }

  @ParameterizedTest
  @ValueSource(strings = { "A", "IVZ", "ABC", "XLVZ" })
  void validRomanNumeral(String input) {
    assertThrows(InvalidRomanNumeralException.class, () -> algorithm.toDecimal(input));
  }

  @ParameterizedTest
  @MethodSource("singleNumerals")
  void singleNumeral(String roman, int decimal) {
    assertEquals(algorithm.toDecimal(roman), decimal);
  }

  @ParameterizedTest
  @MethodSource("romanNumerals")
  void romanNumeralsTest(String roman, int decimal) {
    assertEquals(algorithm.toDecimal(roman), decimal);
  }

  private static Stream<Arguments> singleNumerals() {
    return Stream.of(
        Arguments.of("I", 1),
        Arguments.of("V", 5),
        Arguments.of("X", 10),
        Arguments.of("L", 50),
        Arguments.of("C", 100),
        Arguments.of("D", 500),
        Arguments.of("M", 1000));
  }

  private static Stream<Arguments> romanNumerals() {
    return Stream.of(
        Arguments.of("MCMXLIV", 1944));
  }
}
