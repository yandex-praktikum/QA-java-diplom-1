package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testGetters() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "testSauce", 30);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("testSauce", ingredient.getName());
        assertEquals(30, ingredient.getPrice(), 0.001);
    }
}

