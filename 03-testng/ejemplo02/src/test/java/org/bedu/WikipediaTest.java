package org.bedu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WikipediaTest {

  private WebDriver driver;

  @BeforeClass
  public void setup() {
    System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized"); // Abra la ventana en su tamaño máximo
    options.addArguments("disable-inforbars"); // Quitar las infobars
    options.addArguments("--disable-extensions"); // Deshabilitar las extensiones
    options.addArguments("--disable-dev-shm-usage"); // Extender el límite de recursos
    options.addArguments("--no-sandbox"); // Deshabilitar seguridad del S.O
    driver = new ChromeDriver(options);
  }

  @AfterClass
  public void quit() {
    if (driver != null) {
      driver.quit(); // Cierra la ventana
    }
  }

  @Test(description = "Wikipedia page title")
  public void pageTitle() throws Exception {
    driver.get("https://www.wikipedia.com");
    Assert.assertEquals(driver.getTitle(), "Wikipedia");
  }

  @Test(description = "Free Encyclopedia")
  public void freeEncyclopedia() {
    driver.get("https://www.wikipedia.com");

    WebElement element = driver.findElement(By.cssSelector(".central-textlogo h1 strong"));

    // Thread.sleep(10000); Detenemos el hilo de ejecución

    Assert.assertEquals(element.getText(), "The Free Encyclopedia");
  }

  @Test(description = "Change to italian")
  public void italian() {
    driver.get("https://www.wikipedia.com");

    WebElement element = driver.findElement(By.id("js-link-box-it"));
    element.click();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    WebElement title = driver.findElement(By.cssSelector(".main-page-header-title"));

    Assert.assertEquals(title.getText(), "Benvenuti su Wikipedia");
  }
}