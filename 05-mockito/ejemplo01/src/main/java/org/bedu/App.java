package org.bedu;

public class App {

  public static void main(String[] args) {
    Weather weather = new Weather();

    double currentWeather = weather.currentWeather(20.659698, -103.349609);
    System.out.println(currentWeather);
  }
}
