# Módulo 5: Java Testing

## Temario

1. [Introducción al testing](01-introduccion-testing)

Se dio una introducción a la importancia de las pruebas, cuál es la diferencia entre Pruebas Unitarias, Pruebas de Integración y Pruebas E2E (End-to-End). Además se realizaron ejemplos sobre cómo hacer pruebas unitarias utilizando `Gradle` y  `JUnit + Jupiter`.

* [Ejemplo 01](01-introduccion-testing/ejemplo01/): Implementación del algoritmo de números primos y primeras pruebas con `JUnit`.
* [Ejemplo 02](01-introduccion-testing/ejemplo02/): Implementación de la estructura de datos `Set` y pruebas unitarias. Importancia de `@BeforeEach`.
* [Reto 01](01-introduccion-testing/reto01/): Implementación de la estructura de datos `Stack` y pruebas unitarias.

2. [Pruebas Unitarias](02-unit-testing)

Se vio otro ejemplo de cómo crear pruebas unitarias utilizando `JUnit + Jupiter`, así como el ejecutar las pruebas utilizando el proceso de `Integración Continua` con `Github Actions`.

* [Ejemplo 01](02-unit-testing/ejemplo01/): Implementación de una mini base de datos con pruebas unitarias.

3. [TestNG](03-testng)

Se dio una introducción al framework de pruebas `TestNG` el cual proclama ser una versión moderna y mejorada del ya conocido `JUnit`.

* [Ejemplo 01](03-testng/ejemplo01/): Implementación de un juego para adivinar un número aleatorio usando `TestNG` para realizar pruebas unitarias.

* [Ejemplo 02](03-testng/ejemplo02/): Implementación de pruebas de integración de la página de Wikipedia usando `TestNG` y `Selenium`.

4. [Black Box Testing](04-black-box-testing/)

Durante las primeras 3 sesiones se implementaron `White Box Testing` el cual consiste en basar las pruebas en la implementación del código. En esta sesión vimos cómo realizar `Black Box Testing` utilizando `Behaviour Driven Development` con `Cucumber`.

* [Ejemplo 01](04-black-box-testing/ejemplo01/): Implementación de un cajero automático y realización de pruebas unitarias con `JUnit` y pruebas de caja negra con `Cucumber`.

5. [Mockito](05-mockito/)

Se dio una introducción a `Mockito`, cuál es la diferencia entre `Mock` y `Spy`, así como la simulación de salidas mediante el uso de los métodos `when` para Mocks y `doReturn` para Spies.

* [Ejemplo 01](05-mockito/ejemplo01/): Implementación de una aplicación que consulta la temperatura actual basado en una latitud y longitud. Las pruebas utilizan `Mock` con `when`.

* [Ejemplo 02](05-mockito/ejemplo02/): Extensión del ejemplo 01 pero ahora consumiendo un API adicional que obtiene la latitud y longitud de acuerdo a la IP actual. Las pruebas utilizan `Spy` con `doReturn`.