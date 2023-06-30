package org.bedu.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CurrentWeatherDTO {
  private double temperature;
  private double windspeed;
  private double winddirection;
  private int weathercode;
  private int is_day;
  private String time;
}