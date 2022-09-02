package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Соусный соус", 88);
    }

    @Test
    public void getPriceTest() {
        float expected = 88;
        float actual = ingredient.getPrice();
        assertEquals(expected, actual, 0);
    }

    @Test
    public void getNameTest() {
        String expected = "Соусный соус";
        String actual = ingredient.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getTypeTest() {
        IngredientType expected = IngredientType.SAUCE;
        IngredientType actual = ingredient.getType();
        assertEquals(expected, actual);
    }
}
