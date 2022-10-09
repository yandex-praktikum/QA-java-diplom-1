import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerGetPriceTest {

    private final IngredientType sauce = SAUCE;
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
                {0, 0, 0},
                {0, 100, 100},
                {100, 0, 200},
                {100, 100, 300},
                {2.90f, 9.90f, 15.7f},
        };
    }
    @Test
    public void shouldGetPrice() {
        Burger burger = new Burger();
        Bun bun = new Bun("test bun name", bunPrice);
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(sauce, "test filling name", ingredientPrice);
        burger.addIngredient(ingredient);
        assertEquals(expectedPrice, burger.getPrice(), 0.0);
    }
}