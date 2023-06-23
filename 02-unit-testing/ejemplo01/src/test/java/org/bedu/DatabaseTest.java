package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

  // Arrange
  private Database db;

  @BeforeEach
  public void setup() {
    db = new Database();
  }

  @Test
  @DisplayName("The size of an empty database is 0")
  public void sizeZero() {
    assertEquals(db.size(), 0);
  }

  @Test
  @DisplayName("Database can insert data")
  public void insert() {
    db.insert(new Product(1, "Coca Cola 3lt"));
    db.insert(new Product(2, "Gansito"));

    assertEquals(db.size(), 2);
  }

  @Test
  @DisplayName("Search by id")
  public void findById() {
    db.insert(new Product(1, "Coca Cola 3lt"));
    db.insert(new Product(2, "Gansito"));
    db.insert(new Product(3, "Mordisko"));
    db.insert(new Product(4, "Sabritas 30g"));

    Product p = db.getById(3);

    assertEquals(p.getId(), 3);
    assertEquals(p.getName(), "Mordisko");
  }

  @Test
  @DisplayName("Database can be cleared")
  public void clear() {
    db.insert(new Product(1, "Coca Cola 3lt"));
    db.insert(new Product(2, "Gansito"));
    db.insert(new Product(3, "Mordisko"));
    db.insert(new Product(4, "Sabritas 30g"));

    int size = db.size();

    db.clear();

    assertNotEquals(size, 0);
    assertEquals(db.size(), 0);
  }
}
