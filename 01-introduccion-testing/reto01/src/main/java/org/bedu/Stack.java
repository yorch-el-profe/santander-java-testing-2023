package org.bedu;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class Stack<T> implements IStack<T> {

  private List<T> data;

  public Stack() {
    data = new LinkedList<>();
  }

  public int size() {
    return data.size();
  }

  public void add(T e) {
    data.add(e);
  }

  public boolean exists(T e) {
    return data.contains(e);
  }

  public T pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }

    int index = size() - 1;
    T last = data.get(index);
    data.remove(index);
    return last;
  }
}
