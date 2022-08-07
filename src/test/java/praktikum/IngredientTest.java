package praktikum;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void createNewIngredient() {
        ingredient = new Ingredient(IngredientType.FILLING, "sausage", 300);
    }

    @Test
    public void getIngredientNameTest() {
        String expected = "sausage";
        assertEquals(expected, ingredient.getName());
    }

    @Test
    public void getIngredientPriceTest() {
        float expected = 300;
        assertEquals(expected, ingredient.getPrice(), 0);
    }

    @Test
    public void getIngredientTypeTest() {
        IngredientType expected = IngredientType.FILLING;
        assertEquals(expected, ingredient.getType());
    }
}
