import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestIngredient {
    @Test
    public void testSauce(){
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Сырный", 25f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Сырный", ingredient.getName());
        assertEquals(25f, ingredient.getPrice(), 0f);
    }
    @Test
    public void testFilling(){
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Кура", 23f);
        assertEquals(IngredientType.FILLING, ingredient.getType());
        assertEquals("Кура", ingredient.getName());
        assertEquals(23f, ingredient.getPrice(), 0f);
    }

}
