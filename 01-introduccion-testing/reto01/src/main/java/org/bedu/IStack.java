package org.bedu;

public interface IStack<T> {

  int size();

  void add(T e);

  T pop();

  boolean exists(T e);
}
