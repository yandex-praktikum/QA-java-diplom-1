package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class TestBurgerGetPriceParametrized {
    Bun testBun;
    Ingredient testIngredient;
    float expectedPrice;
    static Bun bun1 = new Bun("test_bun1", 0.00F);
    static Bun bun2 = new Bun("test_bun2", 10.99F);
    static Bun bun3 = new Bun("test_bun3", 10.00F);
    static Bun bun4 = new Bun("test_bun4", -10.99F);
    static Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "test_name1", 12.99F);
    static Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "test_name2", 12.99F);
    static Ingredient ingredient3 = new Ingredient(IngredientType.SAUCE, "test_name3", 0.00F);
    static Ingredient ingredient4 = new Ingredient(IngredientType.SAUCE, "test_name4", 12.99F);

    public TestBurgerGetPriceParametrized(Bun bun, Ingredient ingredient, float expectedPrice) {
        this.testBun = bun;
        this.testIngredient = ingredient;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunAndIngredient() {
        return new Object[][]{
                {bun1, ingredient1, 12.99F},
                {bun2, ingredient2, 34.97F},
                {bun3, ingredient3, 20.00F},
                {bun4, ingredient4, -8.99F}
        };
    }

    @Test
    public void checkGetPriceForDiffParams() {
        Burger testBurger = new Burger();
        testBurger.setBuns(testBun);
        testBurger.addIngredient(testIngredient);
        Assert.assertEquals( expectedPrice, testBurger.getPrice(), 0.0F);
    }
}
