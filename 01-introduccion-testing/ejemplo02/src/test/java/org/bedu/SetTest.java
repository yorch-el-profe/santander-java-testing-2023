package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SetTest {

  private Set<Integer> set;

  @BeforeEach
  public void setup() {
    set = new Set<>();
  }

  @Test
  @DisplayName("An element exists if the set is empty")
  public void existsIfEmpty() {
    set.add(1);
    assertTrue(set.exists(1));
  }

  @Test
  @DisplayName("An element exists if the set has elements")
  public void existsIfNonEmpty() {
    set.add(1);
    set.add(2);
    set.add(3);
    assertTrue(set.exists(3));
  }

  @Test
  @DisplayName("It throws an exception when a element already exists")
  public void throwsException() {
    set.add(1);
    assertThrows(IllegalArgumentException.class, () -> set.add(1));
  }

  @Test
  @DisplayName("It clears the set")
  public void clear() {
    set.add(1);
    set.add(2);
    set.add(3);
    set.clear();
    assertEquals(set.size(), 0);
  }
}
