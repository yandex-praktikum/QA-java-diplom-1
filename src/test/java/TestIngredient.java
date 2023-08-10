import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestIngredient {
    @Test
    public void testIngredient(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сырный", 25f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Сырный", ingredient.getName());
        assertEquals(25f, ingredient.getPrice(), 0f);
    }
}
