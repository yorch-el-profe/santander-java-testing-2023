package org.bedu;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    IRandomNumberGenerator generator = new RandomNumberGenerator();
    GuessNumberGame game = new GuessNumberGame(generator);
    Scanner sc = new Scanner(System.in);

    try {
      System.out.println("Adivina un número entre 0 y 100");
      game.startGame();

      boolean hasWon = false;

      while (!hasWon) {
        System.out.println("Ingresa tu número:");
        int number = sc.nextInt();

        hasWon = game.guessNumber(number);

        if (!hasWon) {
          System.out.println("Intenta de nuevo...");
        }
      }
    } catch (GameOverException ex) {
      System.out.println("Perdiste :(");
    }
  }
}
