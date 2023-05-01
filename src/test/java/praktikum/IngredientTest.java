package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

  private final float expectedPrice;
  private final String expectedName;
  private final IngredientType expectedIngredientType;

  private final Ingredient ingredient;

  public IngredientTest(
      float expectedPrice, String expectedName, IngredientType expectedIngredientType) {
    this.expectedPrice = expectedPrice;
    this.expectedName = expectedName;
    this.expectedIngredientType = expectedIngredientType;
    ingredient = new Ingredient(expectedIngredientType, expectedName, expectedPrice);
  }

  @Parameterized.Parameters(name = "price: {0}, name: {1}, type: {2}")
  public static Object[][] params() {
    return new Object[][] {
      {0f, "test1", IngredientType.SAUCE},
      {1f, "test1", IngredientType.SAUCE},
      {-1f, "test3", IngredientType.FILLING},
      {0f, "", IngredientType.FILLING},
      {0f, null, IngredientType.FILLING},
      {0f, "test4", null},
      {1f, "!@$#^%$&!@", IngredientType.FILLING},
    };
  }

  @Test
  public void getPriceTest() {
    float price = ingredient.getPrice();
    assertEquals(expectedPrice, price, 0f);
  }

  @Test
  public void getNameTest() {
    String name = ingredient.getName();
    assertEquals(expectedName, name);
  }

  @Test
  public void getTypeTest() {
    IngredientType type = ingredient.getType();
    assertEquals(expectedIngredientType, type);
  }
}
