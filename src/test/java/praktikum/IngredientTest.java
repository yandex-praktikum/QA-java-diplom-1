package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "white sauce", 1000);
        assertEquals(1000, ingredient.getPrice(),0.001f);
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(SAUCE, "white sauce", 1000);
        assertEquals("white sauce", ingredient.getName());
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(SAUCE, "white sauce", 1000);
        assertEquals(SAUCE, ingredient.getType());
    }
}