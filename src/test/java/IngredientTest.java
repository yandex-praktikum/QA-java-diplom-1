import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testIngredientCreation() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "BBQ Sauce", 50);

        assertNotNull(ingredient);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("BBQ Sauce", ingredient.getName());
        assertEquals(50, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testIngredientType() {
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Mayo", 20);
        assertEquals(IngredientType.SAUCE, sauce.getType());

        Ingredient filling = new Ingredient(IngredientType.FILLING, "Cheese", 30);
        assertEquals(IngredientType.FILLING, filling.getType());
    }

    @Test
    public void testIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 10);
        assertEquals("Ketchup", ingredient.getName());
    }

    @Test
    public void testIngredientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Mustard", 15);
        assertEquals(15, ingredient.getPrice(), 0.01);
    }
}

