import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientUnitTest {
    @Test
    public void testGetIngredientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.5f);
        assertEquals(0.5f, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.5f);
        assertEquals("Lettuce", ingredient.getName());
    }

    @Test
    public void testGetIngredientType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Lettuce", 0.5f);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
