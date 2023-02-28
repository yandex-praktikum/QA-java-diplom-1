package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String name = "kepchuk";
    private final float price = 250.0f;
    private Ingredient ingredient;

    @Before
    public void createInstance() {
        ingredient = new Ingredient(IngredientType.SAUCE, name, price);
    }

    @Test
    public void checkGetNameTest() {
        String actual = ingredient.getName();
        assertEquals(name, actual);
    }

    @Test
    public void checkGetPriceTest() {
        float actual = ingredient.getPrice();
        assertEquals(price, actual, 0f);
    }
}
