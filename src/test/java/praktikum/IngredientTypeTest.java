package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

  private final String expectedName;
  private final String expectedToString;
  private final IngredientType ingredientType;

  public IngredientTypeTest(
      String expectedName, String expectedToString, IngredientType ingredientType) {
    this.expectedName = expectedName;
    this.expectedToString = expectedToString;
    this.ingredientType = ingredientType;
  }

  @Parameterized.Parameters(name = "type name: {0}, toString: {1}")
  public static Object[][] params() {
    return new Object[][] {
      {"SAUCE", "sauce", IngredientType.SAUCE},
      {"FILLING", "filling", IngredientType.FILLING},
    };
  }

  @Test
  public void nameTest() {
    assertEquals(expectedName, ingredientType.name());
  }

  @Test
  public void toStringTest() {
    assertEquals(expectedToString, ingredientType.toString().toLowerCase());
  }

  @Test
  public void valueOfTest() {
    assertEquals(ingredientType, IngredientType.valueOf(expectedName));
  }
}
