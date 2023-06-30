package org.bedu;

import org.bedu.dto.WeatherDTO;
import org.bedu.util.Axios;
import org.bedu.util.ThermalSensation;

public class Weather {

  private Axios axios;

  public Weather() {
    axios = new Axios();
  }

  public double currentWeather(double latitude, double longitude) {
    String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude
        + "&current_weather=true";
    WeatherDTO data = axios.request(url, WeatherDTO.class);
    return data.getCurrent_weather().getTemperature();
  }

  public ThermalSensation currentThermalSensation(double latitude, double longitude) {
    return ThermalSensation.COLD;
  }
}
