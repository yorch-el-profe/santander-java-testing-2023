package org.bedu;

import java.util.Scanner;

public class App {

  private Database db;
  private Scanner sc;

  public App(Database db, Scanner sc) {
    this.db = db;
    this.sc = sc;
  }

  public void showMenu() {
    int option = 0;

    while (option != 2) {
      System.out.println("1. Agregar usuario");
      System.out.println("2. Salir");
      option = sc.nextInt();

      switch (option) {
        case 1:
          addInterviewee();
      }
    }

    System.out.println("Terminado");
  }

  public void addInterviewee() {
    System.out.println("Ingresa su nombre:");
    String name = sc.nextLine();

    System.out.println("Ingresa su correo:");
    String email = sc.nextLine();

    db.insert(new Interviewee(name, email));

    System.out.println("Agregado!");
  }

  public static void main(String... args) {
    Database db = new Database();
    new App(db).showMenu();
  }
}
