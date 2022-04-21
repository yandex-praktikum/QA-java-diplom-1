package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BurgerPriceTest {

    Float bunPrice;
    Float ingredientPrice0;
    Float ingredientPrice1;
    Float expectedPrice;

    public BurgerPriceTest(Float bunPrice, Float ingredientPrice0, Float ingredientPrice1, Float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice0 = ingredientPrice0;
        this.ingredientPrice1 = ingredientPrice1;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {0f, 0f, 0f, 0f},
                {2f, 0f, 0f, 4f},
                {0f, 1f, 2f, 3f},
                {2f, 1f, 1f, 6f},
        };
    }

    @Test
    public void methodGetPriceShouldReturnBurgerPrice() {
        String name = RandomStringUtils.randomAlphabetic(10);
        Burger burger = new Burger();
        Bun bun = new Bun(name, bunPrice);
        Ingredient ingredient0 = new Ingredient(IngredientType.SAUCE, name, ingredientPrice0);
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, name, ingredientPrice1);

        burger.setBuns(bun);
        burger.addIngredient(ingredient0);
        burger.addIngredient(ingredient1);

        Float burgerPice = burger.getPrice();
        Assert.assertEquals("he expected price does not match actual price", burgerPice, expectedPrice);

    }
}
