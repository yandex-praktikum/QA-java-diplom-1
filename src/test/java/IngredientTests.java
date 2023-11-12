import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTests {

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test_1 ingredient", 100);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test_1 ingredient", 100);
        assertEquals("test_1 ingredient", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test_1 ingredient", 100);
        assertEquals(100.0f, ingredient.getPrice(), 0.01);
    }
}