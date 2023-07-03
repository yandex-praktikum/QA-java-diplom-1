package praktikum;

import junit.framework.TestCase;

import static praktikum.IngredientType.SAUCE;

public class IngredientTest extends TestCase {

    private final String ingredientName = "соус";
    private final float ingredientPrice = 2f;

    Ingredient ingredient = new Ingredient(SAUCE, ingredientName, ingredientPrice);

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