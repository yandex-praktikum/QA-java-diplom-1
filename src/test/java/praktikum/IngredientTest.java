package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сырный", 2.55f);
        float actual = ingredient.getPrice();
        float expected = 2.55f;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getNameShouldReturnCorrectName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сырный", 2.55f);
        String actual = ingredient.getName();
        String expected = "Сырный";
        assertEquals(expected, actual);
    }
}