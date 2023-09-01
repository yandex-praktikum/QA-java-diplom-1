package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, "Ingredient", 1.0f);
    }

    @Test
    public void testGetPrice() {
        assertEquals(1.0f, ingredient.getPrice(), 0.01);
    }

    @Test
    public void testGetName() {
        assertEquals("Ingredient", ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}