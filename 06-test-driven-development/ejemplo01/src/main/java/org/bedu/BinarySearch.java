package org.bedu;

public class BinarySearch {

  public int search(int[] list, int element) {
    return searchAux(list, element, 0, list.length - 1);
  }

  private int searchAux(int[] list, int element, int start, int end) {
    int length = end - start + 1;
    int middle = Math.floorDiv(length, 2) + start;

    if (list[middle] == element) {
      return middle;
    } else if (list[start] == element) {
      return start;
    } else if (list[end] == element) {
      return end;
    }

    if (start == end) {
      return -1;
    } else if (element < list[middle]) {
      return searchAux(list, element, start, middle);
    } else {
      return searchAux(list, element, middle, end);
    }
  }
}