package org.bedu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class IPDTO {
  private String status;
  private String country;
  private String countryCode;
  private String region;
  private String regionName;
  private String city;
  private String zip;
  private double lat;
  private double lon;
  private String timezone;
  private String isp;
  private String org;
  private String as;
  private String query;
}