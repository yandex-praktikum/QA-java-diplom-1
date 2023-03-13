package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static praktikum.IngredientType.FILLING;

public class TestBurgerGetPrice {
    Bun testBun = new Bun("test_bun", 12.90F);
    Ingredient testIngredient = new Ingredient(FILLING, "test_ingredient", 15.00F);
    Float expectedPrice = 40.80F;

    @Test
    public void checkBurgerGetPrice() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(testIngredient);
        testBurger.setBuns(testBun);
        float actualPrice = testBurger.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0.0F);
    }

    @Test(expected = NullPointerException.class)
    public void checkBurgerGetPriceFailNoBun() {
        Burger testBurger = new Burger();
        testBurger.addIngredient(testIngredient);
        testBurger.getPrice();
    }
}
