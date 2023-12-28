package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    @Test
    public void testGetTypeIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "sausage", 300F);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @Test
    public void testGetNameIngredient() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 200F);
        assertEquals("sour cream", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100F);
        assertEquals(100F, ingredient.getPrice(), 0);
    }
}