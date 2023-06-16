package org.bedu;

import java.util.LinkedList;
import java.util.List;

public class Set<T> {

  private List<T> data;

  public Set() {
    data = new LinkedList<>();
  }

  public int size() {
    return data.size();
  }

  public void clear() {
    data.clear();
  }

  public boolean exists(T element) {
    return data.contains(element);
  }

  public void add(T element) {
    if (exists(element)) {
      throw new IllegalArgumentException();
    }

    data.add(element);
  }
}
