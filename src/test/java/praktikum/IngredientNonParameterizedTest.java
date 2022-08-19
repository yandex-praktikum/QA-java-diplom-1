package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IngredientNonParameterizedTest {
    private Ingredient ingredient;

    @Before
    public void setup() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Cheese", 1f);
    }

    @Test
    public void getPriceTest() {
        float result = ingredient.getPrice();
        float expected = 1f;
        Assert.assertEquals(expected, result, 0.01f);
    }

    @Test
    public void getNameTest() {
        String result = ingredient.getName();
        String expected = "Cheese";
        Assert.assertEquals(expected, result);
    }

}
