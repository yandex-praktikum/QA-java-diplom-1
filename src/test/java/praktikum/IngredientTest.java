package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        assertEquals(100, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 50);
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}