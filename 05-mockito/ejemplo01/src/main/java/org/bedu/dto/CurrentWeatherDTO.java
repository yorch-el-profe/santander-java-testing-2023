package org.bedu.dto;

import lombok.Data;

@Data
public class CurrentWeatherDTO {
  private double temperature;
  private double windspeed;
  private double winddirection;
  private int weathercode;
  private int is_day;
  private String time;
}