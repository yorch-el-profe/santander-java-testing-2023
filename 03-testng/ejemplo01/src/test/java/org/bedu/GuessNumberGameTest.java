package org.bedu;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GuessNumberGameTest {

  private GuessNumberGame game;

  // Queremos crear una instancia del juego
  // antes de ejecutar todas las pruebas
  // JUnit: @BeforeAll
  // TestNG: @BeforeClass
  @BeforeClass
  public void initialSetup() {
    IRandomNumberGenerator generator = new FakeRandomNumberGenerator();
    game = new GuessNumberGame(generator);
  }

  // Queremos iniciar un nuevo juego
  // antes de cada prueba
  // JUnit: @BeforeEach
  // TestNG: @BeforeMethod
  @BeforeMethod
  public void startGame() {
    game.startGame();
  }

  @Test(description = "Number of tries are 0 on each new game")
  public void triesZero() {
    int tries = game.getTries();
    Assert.assertEquals(tries, 0);
  }

  @Test(description = "The number must be in an specific range")
  public void outOfRange() {
    Assert.assertThrows(OutOfRangeException.class, () -> game.guessNumber(-100));
    Assert.assertThrows(OutOfRangeException.class, () -> game.guessNumber(100));
  }

  @Test(description = "The game must return false when the number is incorrect")
  public void wrongNumber() {
    boolean result = game.guessNumber(8);
    Assert.assertFalse(result);
  }

  @Test(description = "The game must return true when the number is correct")
  public void correctNumber() {
    boolean result = game.guessNumber(5);
    Assert.assertTrue(result);
  }

  @Test(description = "The game must finish at 3rd try")
  public void gameOver() {
    game.guessNumber(1);
    game.guessNumber(2);
    Assert.assertThrows(GameOverException.class, () -> game.guessNumber(10));
  }

}
