package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.bedu.dto.CurrentWeatherDTO;
import org.bedu.dto.IPDTO;
import org.bedu.dto.WeatherDTO;
import org.bedu.util.Axios;
import org.bedu.util.ThermalSensation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherTest {

  private Weather weather;
  private Axios axios;

  @BeforeEach
  public void setup() {
    // Spy: Una simulación de un objeto
    // pero que permite monitorea sus llamadas a los métodos.
    axios = Mockito.spy(new Axios());
    weather = new Weather(axios);
  }

  @Test
  @DisplayName("should return API temperature")
  public void apiTemperature() {
    double expectedTemperature = 23.2;

    // En el caso de los spy, se utiliza "doReturn" en vez de "when"
    doReturn(createMock(expectedTemperature)).when(axios).request(anyString(), any());

    double temperature = weather.currentWeather(20.659698, -103.349609);

    assertEquals(temperature, expectedTemperature);
  }

  @Test
  @DisplayName("It's hot")
  public void hot() {
    doReturn(createMock(28)).when(axios).request(anyString(), any());

    ThermalSensation sensation = weather.currentThermalSensation(20.659698, -103.349609);

    assertEquals(sensation, ThermalSensation.HOT);
  }

  @Test
  @DisplayName("It's cold")
  public void cold() {
    doReturn(createMock(5)).when(axios).request(anyString(), any());

    ThermalSensation sensation = weather.currentThermalSensation(20.659698, -103.349609);

    assertEquals(sensation, ThermalSensation.COLD);
  }

  @Test
  @DisplayName("It's warm")
  public void warm() {
    doReturn(createMock(15)).when(axios).request(anyString(), any());

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
    doReturn(IPDTO.builder().lat(latitude).lon(longitude).build())
        .when(axios)
        .request(eq("http://ip-api.com/json"), eq(IPDTO.class));

    // Mock cuando se llame el API del clima
    String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude
        + "&current_weather=true";
    doReturn(createMock(expectedTemperature))
        .when(axios)
        .request(eq(url), eq(WeatherDTO.class));

    double currentWeather = weather.localWeather();

    assertEquals(currentWeather, expectedTemperature);

    // Valida que el método "axios.request"
    // se ha invocado 2 veces
    verify(axios, times(2)).request(anyString(), any());
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
