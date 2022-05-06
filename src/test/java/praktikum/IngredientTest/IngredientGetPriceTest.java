package praktikum.IngredientTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientGetPriceTest {
    private final float price;
    private final float expectedPrice;

    public IngredientGetPriceTest(float price, float expectedPrice) {
        this.price = price;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {100.f, 100.f},
                {200.0f, 200.0f},
                {300.00f, 300.00f},
                {0.f, 0.f},
                {-1.f, -1.f},
                {20.158f, 20.158f}
        };
    }

    @Test
    public void shouldCheckGetPriceReturnExactPrice() {

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "hot sauce", price);
        float actualPrice = ingredient.getPrice();
        assertEquals("return invalid price", expectedPrice, actualPrice, 0.00f);

    }

}
