package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {

  private final float expectedPrice;
  private final String expectedName;

  private final Bun bun;

  public BunTest(float expectedPrice, String expectedName) {
    this.expectedPrice = expectedPrice;
    this.expectedName = expectedName;
    bun = new Bun(expectedName, expectedPrice);
  }

  @Parameterized.Parameters(name = "price: {0}, name: {1}")
  public static Object[][] params() {
    return new Object[][] {
      {0f, "test1"},
      {1f, "test2"},
      {-1f, "test3"},
      {0f, ""},
      {0f, null},
      {0f, "!@#$!#$!@$^*&!@%$^"},
      {1.1f, "test5"},
      {-1.1f, "test6"},
    };
  }

  @Test
  public void getNameTest() {
    String name = bun.getName();
    assertEquals(expectedName, name);
  }

  @Test
  public void getPriceTest() {
    float price = bun.getPrice();
    assertEquals(expectedPrice, price, 0.0f);
  }
}
