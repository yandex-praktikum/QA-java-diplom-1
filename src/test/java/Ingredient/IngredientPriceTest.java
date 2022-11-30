package Ingredient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientPriceTest {

    private final float priceIngredient;
    private final float expected;
    private final float DELTA = 0.001f;

    public IngredientPriceTest (float priceIngredient, float expected) {
        this.priceIngredient = priceIngredient;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] priceParam() {
        return new Object[][] {
                {0.01f, 0.01f},
                {1.99f, 1.99f},
                {11, 11}
        };
    }

    @Test
    public void getIngredientPrice() {
        Ingredient ingredient = new Ingredient(SAUCE, "beef", priceIngredient);
        float actual = ingredient.getPrice();
        assertEquals("Данные не совпадают", expected, actual, DELTA);
    }
}
