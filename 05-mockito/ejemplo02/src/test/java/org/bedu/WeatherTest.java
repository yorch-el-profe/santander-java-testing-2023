package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

import org.bedu.dto.CurrentWeatherDTO;
import org.bedu.dto.IPDTO;
import org.bedu.dto.WeatherDTO;
import org.bedu.util.Axios;
import org.bedu.util.ThermalSensation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherTest {

  private static Weather weather;
  private static Axios axios;

  @BeforeAll
  public static void setup() {
    axios = Mockito.mock(Axios.class);
    weather = new Weather(axios);
  }

  @Test
  @DisplayName("should return API temperature")
  public void apiTemperature() {
    double expectedTemperature = 23.2;

    when(axios.request(anyString(), any())).thenReturn(createMock(expectedTemperature));

    double temperature = weather.currentWeather(20.659698, -103.349609);

    assertEquals(temperature, expectedTemperature);
  }

  @Test
  @DisplayName("It's hot")
  public void hot() {
    when(axios.request(anyString(), any())).thenReturn(createMock(28));

    ThermalSensation sensation = weather.currentThermalSensation(20.659698, -103.349609);

    assertEquals(sensation, ThermalSensation.HOT);
  }

  @Test
  @DisplayName("It's cold")
  public void cold() {
    when(axios.request(anyString(), any())).thenReturn(createMock(5));

    ThermalSensation sensation = weather.currentThermalSensation(20.659698, -103.349609);

    assertEquals(sensation, ThermalSensation.COLD);
  }

  @Test
  @DisplayName("It's warm")
  public void warm() {
    when(axios.request(anyString(), any())).thenReturn(createMock(15));

    ThermalSensation sensation = weather.currentThermalSensation(20.659698, -103.349609);

    assertEquals(sensation, ThermalSensation.WARM);
  }

  @Test
  @DisplayName("Local weather")
  public void localWeather() {
    double latitude = 19.4326;
    double longitude = -99.1332;
    double expectedTemperature = 18.5;

    // Mock cuando se llame el API de la IP
    when(axios.request(eq("http://ip-api.com/json"), eq(IPDTO.class)))
        .thenReturn(IPDTO.builder().lat(latitude).lon(longitude).build());

    // Mock cuando se llame el API del clima
    String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude
        + "&current_weather=true";
    when(axios.request(eq(url), eq(WeatherDTO.class)))
        .thenReturn(createMock(expectedTemperature));

    double currentWeather = weather.localWeather();

    assertEquals(currentWeather, expectedTemperature);
  }

  private WeatherDTO createMock(double expectedTemperature) {
    // Dato de prueba
    CurrentWeatherDTO currentWeather = CurrentWeatherDTO
        .builder()
        .temperature(expectedTemperature)
        .build();

    return WeatherDTO
        .builder()
        .current_weather(currentWeather)
        .build();
  }
}
