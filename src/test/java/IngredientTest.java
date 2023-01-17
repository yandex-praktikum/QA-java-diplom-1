import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    final String burgerFilling = "meat";
    final int fillingPrice = 3000;

    Ingredient ingredient = new Ingredient(IngredientType.FILLING, burgerFilling, fillingPrice);

    @Test
    public void getPriceTest() {
        float expected = fillingPrice;
        float actual = ingredient.getPrice();
        assertEquals("Price is not correct",expected, actual, 0);
    }

    @Test
    public void getNameTest() {
        String expected = burgerFilling;
        String actual = ingredient.getName();
        assertEquals("Name of ingredient is not correct", expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.FILLING;
        IngredientType actual = ingredient.getType();
        assertEquals("Type of ingredient is not correct", expected, actual);
    }
}