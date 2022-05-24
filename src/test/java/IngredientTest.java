import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void shouldReturnPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "name", 34);
        float actual = ingredient.getPrice();
        float expected = 34;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void shouldReturnName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "name", 34);
        String actual = ingredient.getName();
        String expected = "name";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIngredientType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "name", 34);
        IngredientType actual = ingredient.getType();
        IngredientType expected = IngredientType.FILLING;
        assertEquals(expected, actual);
    }
}
