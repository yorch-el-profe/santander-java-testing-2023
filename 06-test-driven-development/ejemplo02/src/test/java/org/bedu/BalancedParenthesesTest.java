package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BalancedParenthesesTest {

  private static BalancedParentheses algorithm;

  @BeforeAll
  public static void setup() {
    algorithm = new BalancedParentheses();
  }

  @Test
  @DisplayName("Empty sequence")
  public void emptySequence() {
    // Act
    int parentheses = algorithm.isBalanced("");

    // Assert
    assertEquals(parentheses, 0);
  }

  @Test
  @DisplayName("Not balanced when there's just one parentheses")
  public void oneParentheses() {
    int parentheses = algorithm.isBalanced("(");
    assertEquals(parentheses, 1);
  }

  @Test
  @DisplayName("Balanced when the sequence is simple")
  public void balancedSimple() {
    assertEquals(algorithm.isBalanced("()"), 0);
    assertEquals(algorithm.isBalanced("((()))"), 0);
    assertEquals(algorithm.isBalanced("(((((((())))))))"), 0);
  }

  @Test
  @DisplayName("Not balance when the sequence is simple")
  public void notBalancedSimple() {
    assertEquals(algorithm.isBalanced("((())"), 1);
    assertEquals(algorithm.isBalanced("((((((())))))))"), 1);
  }

  @Test
  @DisplayName("Balanced when the sequence is complex")
  public void balancedComplex() {
    assertEquals(algorithm.isBalanced("()()"), 0);
    assertEquals(algorithm.isBalanced("()()()()()()()"), 0);
    assertEquals(algorithm.isBalanced("(()())"), 0);
    assertEquals(algorithm.isBalanced("((()()))(())((((())())))"), 0);
  }

  @Test
  @DisplayName("Not balanced when the sequence is complex")
  public void notBalancedComplex() {
    assertEquals(algorithm.isBalanced(")("), 2);
    assertEquals(algorithm.isBalanced("))"), 2);
    assertEquals(algorithm.isBalanced("()()()())"), 1);
    assertEquals(algorithm.isBalanced("()()()()("), 1);
    assertEquals(algorithm.isBalanced("()(()((((()))))(())()"), 1);
  }
}
