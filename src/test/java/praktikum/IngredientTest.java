package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Hot sauce", 50);
        assertEquals("Hot sauce", ingredient.getName());
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cutlet", 100);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

}