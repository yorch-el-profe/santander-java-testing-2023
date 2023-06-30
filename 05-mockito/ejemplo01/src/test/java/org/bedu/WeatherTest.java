package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

import org.bedu.dto.CurrentWeatherDTO;
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
    // Simulando la implementación de la clase "Axios"
    axios = Mockito.mock(Axios.class);

    // El objeto de prueba utiliza el "mock" (simulación)
    weather = new Weather(axios);
  }

  @Test
  @DisplayName("should return API temperature")
  public void apiTemperature() {
    double expectedTemperature = 23.2;

    // Cuando se invoque el método "axios.request"
    // con cualquier cadena de texto (anyString) y
    // cualquier otro parámetro (any) regrese el objeto weather
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
