import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "сырный соус", 20);
    }

    @Test
    public void checkGetNameCorrectReturn() {
        assertEquals("Name should equals to сырный соус", ingredient.getName(), "сырный соус");
    }

    @Test
    public void checkGetPriceCorrectReturn() {
        assertEquals("Price should equals to 20", ingredient.getPrice(), 20, 0);
    }

    @Test
    public void checkGetTypeCorrectReturn() {
        assertEquals("IngredientType should equals to SAUCE", ingredient.getType(), IngredientType.SAUCE);
    }
}
