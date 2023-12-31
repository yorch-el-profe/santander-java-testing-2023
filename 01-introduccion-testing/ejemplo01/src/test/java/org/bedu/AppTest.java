package org.bedu;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {

  // Arrange: Configuraciones previas
  private static App app;

  // @BeforeAll Se ejecuta antes de todas las pruebas (método estático)
  // @BeforeEach Se ejecuta antes de cada prueba
  // @AfterAll Se ejecuta después de todas las pruebas (método estático)
  // @AfterEach Se ejecuta después de cada prueba
  @BeforeAll
  public static void setup() {
    app = new App();
  }

  @Test
  @DisplayName("Negative numbers")
  public void negativeNumbers() {
    // Action: La ejecución del código a probar
    boolean result = app.isPrime(-1);

    // Assert: Probar el valor esperado
    assertFalse(result);
  }

  @Test
  @DisplayName("Zero and One")
  public void zeroAndOne() {
    assertFalse(app.isPrime(0));
    assertFalse(app.isPrime(1));
  }

  @Test
  @DisplayName("Prime Numbers")
  public void primeNumbers() {
    assertTrue(app.isPrime(2));
    assertTrue(app.isPrime(3));
    assertTrue(app.isPrime(5));
    assertTrue(app.isPrime(127));
  }
}
