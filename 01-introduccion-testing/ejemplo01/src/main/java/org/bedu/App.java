package org.bedu;

public class App {

  public boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }

    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String... args) {
    App app = new App();

    System.out.println(app.isPrime(13));
    System.out.println(app.isPrime(100));
  }
}