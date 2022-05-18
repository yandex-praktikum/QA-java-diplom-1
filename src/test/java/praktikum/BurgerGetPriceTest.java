package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)

public class BurgerGetPriceTest {

    private final IngredientType sauceType = SAUCE;
    private final String fillingName = "Говядина";
    private final String bunName = "Black";
    private final float bunPrice;
    private final float ingredientPrice;
    private final float expectedPrice;

    public BurgerGetPriceTest(float bunPrice, float ingredientPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice = ingredientPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData() {
        return new Object[][]{
                {10, 100, 120},
                {0, 100, 100},
                {500, 0, 1000},
                {25.50f, 555.10f, 606.10f},
                {0, 0, 0},
        };
    }

    @Test
    public void burgerPrice() {
        Burger burger = new Burger();
        Bun bun = new Bun(bunName, bunPrice);
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(sauceType, fillingName, ingredientPrice);
        burger.addIngredient(ingredient);
        float actualPrice = burger.getPrice();
        assertEquals(expectedPrice, actualPrice, 0);
    }
}

