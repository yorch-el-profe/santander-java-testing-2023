package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StackTest {

  private Stack<Integer> s;

  @BeforeEach
  public void setup() {
    s = new Stack<>();
  }

  @Test
  @DisplayName("Size is 0 when stack is empty")
  public void sizeZero() {
    assertEquals(s.size(), 0);
  }

  @Test
  @DisplayName("Adds elements to stack")
  public void add() {
    s.add(100);
    s.add(200);
    s.add(300);
    assertEquals(s.size(), 3);
  }

  @Test
  @DisplayName("Contains a certain element")
  public void exists() {
    s.add(1000);
    s.add(2000);
    s.add(3000);
    s.add(4000);
    s.add(5000);
    assertTrue(s.exists(3000));
  }

  @Test
  @DisplayName("Does not contain a certain element")
  public void notExists() {
    s.add(1000);
    s.add(2000);
    s.add(3000);
    s.add(4000);
    s.add(5000);
    assertFalse(s.exists(6000));
  }

  @Test
  @DisplayName("Throws an exception when pops an empty stack")
  public void popException() {
    assertThrows(EmptyStackException.class, () -> s.pop());
  }

  @Test
  @DisplayName("Removes and retrieves the last element")
  public void pop() {
    s.add(10);
    s.add(20);
    s.add(30);
    int last = s.pop();

    assertEquals(last, 30);
    assertEquals(s.size(), 2);
    assertFalse(s.exists(30));
  }
}
