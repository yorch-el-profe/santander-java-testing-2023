package org.bedu.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Axios {

  private ObjectMapper mapper;

  public Axios() {
    mapper = new ObjectMapper();
  }

  public <T> T request(String url, Class<T> clazz) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .build();

    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      String body = response.body();
      return mapper.readValue(body, clazz);
    } catch (IOException | InterruptedException ex) {
      ex.printStackTrace();
      throw new AxiosException();
    }
  }
}