import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class TestIngredientType {
    @Test
    public void testIngredientType() {
        Ingredient ingredient = new Ingredient(FILLING, "Булочка", 5.05F);
        assertEquals(String.valueOf(ingredient.getType()), String.valueOf(FILLING));
    }
}
