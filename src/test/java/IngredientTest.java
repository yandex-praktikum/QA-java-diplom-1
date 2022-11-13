import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import praktikum.*;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setup() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Томатный соус", 30);
    }

    @Test
    public void shouldReturnPrice() {
        float expected = 30;
        assertEquals(expected, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldReturnName() {
        String expected = "Томатный соус";
        assertEquals(expected, ingredient.getName());
    }

    @Test
    public void shouldReturnIngredientType() {
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, ingredient.getType());
    }
}