package org.bedu;

import org.bedu.util.Axios;

public class App {

  public static void main(String[] args) {
    Axios axios = new Axios();
    Weather weather = new Weather(axios);

    double currentWeather = weather.localWeather();
    System.out.println(currentWeather);
  }
}
