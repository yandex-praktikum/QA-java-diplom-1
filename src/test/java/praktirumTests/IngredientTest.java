package praktirumTests;

import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Space Sauce", 80.0f);

    @Test
    public void getPriceTest() {
        float expected = 80.0f;
        float actual = ingredient.getPrice();
        assertEquals("Не совпадает цена",expected, actual, 0.00f);
    }

    @Test
    public void getNameTest() {
        String expected = "Space Sauce";
        String actual = ingredient.getName();
        assertEquals("Не совпадает название", expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();
        assertEquals("Не совпадают ингридиенты", expected, actual);
    }
}
