package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {

  private static BinarySearch algorithm;

  @BeforeAll
  public static void setup() {
    algorithm = new BinarySearch();
  }

  @Test
  @DisplayName("Find a number in a list with a single number")
  public void findOneNumber() {
    int[] list = new int[] { 100 };

    int index = algorithm.search(list, 100);

    assertEquals(index, 0);
  }

  @Test
  @DisplayName("Get -1 in a list with a single element")
  public void notFoundOneNumber() {
    int[] list = new int[] { 50 };

    int index = algorithm.search(list, 80);

    assertEquals(index, -1);
  }

  @Test
  @DisplayName("The element is in the middle of the list")
  public void middle() {
    int[] listOdd = new int[] { 10, 20, 30, 40, 50 };

    int[] listEven = new int[] { 10, 20, 30, 40 };

    int indexOdd = algorithm.search(listOdd, 30);

    assertEquals(indexOdd, 2);

    int indexEven = algorithm.search(listEven, 30);

    assertEquals(indexEven, 2);
  }

  @Test
  @DisplayName("First element of the list")
  public void firstElement() {
    int[] list = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    int index = algorithm.search(list, 1);

    assertEquals(index, 0);
  }

  @Test
  @DisplayName("Last element of the list")
  public void lastElement() {
    int[] list = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    int index = algorithm.search(list, 10);

    assertEquals(index, 9);
  }

  @Test
  @DisplayName("Left side")
  public void leftSide() {
    int[] list = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    int index = algorithm.search(list, 2);

    assertEquals(index, 1);
  }

  @Test
  @DisplayName("Right side")
  public void rightSide() {
    int[] list = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    int index = algorithm.search(list, 9);

    assertEquals(index, 8);
  }

  @Test
  @DisplayName("Not found")
  public void notFound() {
    int[] list = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    int index = algorithm.search(list, 11);

    assertEquals(index, -1);
  }
}
