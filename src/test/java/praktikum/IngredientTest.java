package praktikum;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest  {

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "Чесночный", 50);
        assertEquals(50.0, ingredient.getPrice(), 0);
    }
    @Test
    public void testTestGetName() {
        Ingredient ingredient = new Ingredient(SAUCE, "Чесночный", 50);
        assertEquals("Чесночный", ingredient.getName());
    }
    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(SAUCE, "Чесночный", 50);
        assertEquals(SAUCE, ingredient.getType());

    }
}


