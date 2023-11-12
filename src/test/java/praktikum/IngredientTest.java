package praktikum;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    static Ingredient ingredientSauce;
    static Ingredient ingredientFilling;
    @BeforeClass
    public static void createBun() {
        ingredientSauce = new Ingredient(IngredientType.SAUCE, "BBQ", 10);
        ingredientFilling = new Ingredient(IngredientType.FILLING, "Salad", 5);
    }

    @Test
    public void getPrice() {
      float expectedPrice = 10;
      assertEquals(expectedPrice, ingredientSauce.getPrice(), 0.0);
    }

    @Test
    public void getName() {
      String expectedName = "BBQ";
      assertEquals(expectedName, ingredientSauce.getName());
    }

    @Test
    public void getTypeSauce() {
      IngredientType expectedSauce = IngredientType.SAUCE;
      assertEquals(expectedSauce, ingredientSauce.getType());
    }

    @Test
    public void getTypeFilling() {
        IngredientType expectedFilling = IngredientType.FILLING;
        assertEquals(expectedFilling, ingredientFilling.getType());
    }
}