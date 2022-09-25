import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class TestIngredient {

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(FILLING, "Булочка", 5.05F);
        assertEquals(ingredient.getPrice(), 5.05F, 0.00F);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(FILLING, "Булочка1", 5.05F);
        assertEquals(ingredient.getName(), "Булочка1");
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(SAUCE, "Булочка", 5.05F);
        assertEquals(ingredient.getType(), SAUCE);
    }
}
