package praktikum;

import junit.framework.TestCase;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest extends TestCase {

    Ingredient ingredient = new Ingredient(SAUCE, "соус", 2f);

    public void testGetPrice() {

        assertEquals(2f,
                ingredient.getPrice());
    }

    public void testGetName() {

        assertEquals("соус",
                ingredient.getName());
    }

    public void testGetType() {

        assertEquals(SAUCE,
                ingredient.getType());
    }
}